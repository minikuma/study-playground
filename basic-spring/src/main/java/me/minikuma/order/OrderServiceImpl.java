package me.minikuma.order;

import me.minikuma.discount.DiscountPolicy;
import me.minikuma.discount.FixDiscountPolicy;
import me.minikuma.member.Member;
import me.minikuma.member.MemberRepository;
import me.minikuma.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 회원 정보
    private final MemberRepository memberRepository;
    // 할인 정보
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String productName, int productPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, productPrice);
        return new Order(1L, memberId, productName, productPrice, discountPrice);
    }
}
