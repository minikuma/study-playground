package me.minikuma.beanfind;

import me.minikuma.discount.DiscountPolicy;
import me.minikuma.discount.FixDiscountPolicy;
import me.minikuma.discount.RateDiscountPolicy;
import me.minikuma.member.MemberRepository;
import me.minikuma.member.MemberService;
import me.minikuma.member.MemberServiceImpl;
import me.minikuma.member.MemoryMemberRepository;
import me.minikuma.singleton.StatefulService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    public MemberRepository memberRepository1() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository1());
    }

    @Bean
    public StatefulService statefulService() {
        return new StatefulService();
    }
}
