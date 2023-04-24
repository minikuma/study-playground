package me.minikuma.singleton;

import me.minikuma.beanfind.TestConfig;
import me.minikuma.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("Singleton 이 적용되지 않은(스프링) DI 컨테이너")
    void pureContainer() {
        TestConfig testConfig = new TestConfig();
        // (1) 조회 할 때마다 객체 생성
        MemberService memberService1 = testConfig.memberService();

        // (2) 조회 할 때마다 객체 생성
        MemberService memberService2 = testConfig.memberService();

        // 참조값 검증
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 객체를 적용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤 검증")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        // 1. 조회 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
