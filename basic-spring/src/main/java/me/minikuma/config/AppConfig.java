package me.minikuma.config;

import me.minikuma.discount.DiscountPolicy;
import me.minikuma.discount.FixDiscountPolicy;
import me.minikuma.member.MemberServiceImpl;
import me.minikuma.member.MemberService;
import me.minikuma.member.MemoryMemberRepository;
import me.minikuma.order.OrderService;
import me.minikuma.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
