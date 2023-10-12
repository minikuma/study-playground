package me.minikuma.service;

import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepositoryV0;

import java.sql.SQLException;

public class MemberServiceV1 {

    private final MemberRepositoryV0 memberRepository;

    public MemberServiceV1(MemberRepositoryV0 memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 계좌 이체
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        // 조회
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        // 업데이트
        memberRepository.update(fromId, fromMember.getMoney() - money);

        // 오류 케이스 (계좌 이체 금액 부족)
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
