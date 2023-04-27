package me.minikuma.singleton;

import me.minikuma.config.AppConfig;
import me.minikuma.member.MemberRepository;
import me.minikuma.member.MemberServiceImpl;
import me.minikuma.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("스프링은 싱글톤으로 유지될까?")
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep() {
        //TODO: 재 테스트 필요
    }
}
