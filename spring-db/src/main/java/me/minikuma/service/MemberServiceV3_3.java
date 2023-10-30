package me.minikuma.service;

import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepositoryV3;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 트랜젝션 AOP
 */
public class MemberServiceV3_3 {
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_3(MemberRepositoryV3 repository) {
        this.memberRepository = repository;
    }

    // 계좌 이체
    @Transactional
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        bizLogic(fromId, toId, money);
    }

    private void bizLogic(String fromId, String toId, int money) throws SQLException {
        // 비즈니스 로직
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);

        // validation check
        validation(fromMember, money);
        transferBalanceValidation(toMember);

        memberRepository.update(toId, toMember.getMoney() + money);
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
