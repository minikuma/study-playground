package me.minikuma.service;

import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepositoryV3;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;

/**
 * 트랜젝션 매니저
 */
public class MemberServiceV3_1 {

    private final PlatformTransactionManager transactionManager;
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_1(PlatformTransactionManager transactionManager, MemberRepositoryV3 repository) {
        this.transactionManager = transactionManager;
        this.memberRepository = repository;
    }

    // 계좌 이체
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {

        // 트랜젝션 매니저
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            bizLogic(fromId, toId, money);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw new IllegalStateException(e);
        }
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
