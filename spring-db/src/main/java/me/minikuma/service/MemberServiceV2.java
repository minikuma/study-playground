package me.minikuma.service;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepositoryV2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 트랜젝션 - 파라미터 연동, DB Pool 고려
 */
@Slf4j
public class MemberServiceV2 {

    private final MemberRepositoryV2 memberRepository;
    private final DataSource dataSource;

    public MemberServiceV2(MemberRepositoryV2 memberRepository, DataSource dataSource) {
        this.memberRepository = memberRepository;
        this.dataSource = dataSource;
    }

    // 계좌 이체
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Connection conn = dataSource.getConnection();
        try {
            // 트랜젝션 시작
            conn.setAutoCommit(false);

            bizLogic(conn, fromId, toId, money);

            conn.commit(); // 성공 시, Commit
        } catch (Exception e) {
            conn.rollback(); // 실패 시, rollback
            throw new IllegalStateException(e);
        } finally {
            release(conn);
        }
    }

    private void bizLogic(Connection conn, String fromId, String toId, int money) throws SQLException {
        // 비즈니스 로직
        Member fromMember = memberRepository.findById(conn, fromId);
        Member toMember = memberRepository.findById(conn, toId);

        memberRepository.update(conn, fromId, fromMember.getMoney() - money);

        // validation check
        validation(fromMember, money);
        transferBalanceValidation(toMember);

        memberRepository.update(conn, toId, toMember.getMoney() + money);
    }

    private void release(Connection conn) {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // 원래 설정 으로 원복 (커넥션 풀 고려)
                conn.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }

    private void validation(Member member, int money) {
        if (member.getMoney() < money) {
            throw new IllegalStateException("계좌 이체 금액 부족!");
        }
    }

    private void transferBalanceValidation(Member member) {
        if (member.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체 도중 예외 발생!");
        }
    }
}
