package me.minikuma.config;

import me.minikuma.discount.DiscountPolicy;
import me.minikuma.discount.RateDiscountPolicy;
import me.minikuma.member.MemberService;
import me.minikuma.member.MemberServiceImpl;
import me.minikuma.member.MemoryMemberRepository;
import me.minikuma.order.OrderService;
import me.minikuma.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
