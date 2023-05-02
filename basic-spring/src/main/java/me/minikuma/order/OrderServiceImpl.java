package me.minikuma.order;

import me.minikuma.annotation.MainDiscountPolicy;
import me.minikuma.discount.DiscountPolicy;
import me.minikuma.member.Member;
import me.minikuma.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    // 회원 정보
    private final MemberRepository memberRepository;
    // 할인 정보
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String productName, int productPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, productPrice);
        return new Order(1L, memberId, productName, productPrice, discountPrice);
    }

    // 스프링 싱글톤을 유지할 수 있는지? 테스트
    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }
}
