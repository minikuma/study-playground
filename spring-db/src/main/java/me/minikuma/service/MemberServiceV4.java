package me.minikuma.service;

import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 예외 누수 해결
 * - SQLException 제거
 * - MemberRepository 인터페이스에 의존
 */
public class MemberServiceV4 {
    private final MemberRepository memberRepository;

    public MemberServiceV4(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 계좌 이체
    @Transactional
    public void accountTransfer(String fromId, String toId, int money) {
        bizLogic(fromId, toId, money);
    }

    private void bizLogic(String fromId, String toId, int money) {
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
