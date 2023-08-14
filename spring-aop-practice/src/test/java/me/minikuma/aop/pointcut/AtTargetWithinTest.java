package me.minikuma.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.annotation.ClassAop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({AtTargetWithinTest.Config.class})
@SpringBootTest
@Slf4j
class AtTargetWithinTest {

    static class Config {
        @Bean
        public Parent parent() {
            return new Parent();
        }

        @Bean
        public Child child() {
            return new Child();
        }

        @Bean
        public AtTargetAtWithAspect atTargetAtWithAspect() {
            return new AtTargetAtWithAspect();
        }
    }

    static class Parent {
        public void parentMethod() {}
    }

    @ClassAop
    static class Child extends Parent {
        public void childMethod() {}
    }

    @Slf4j
    @Aspect
    static class AtTargetAtWithAspect {
        // @Target: 인스턴스 기준으로 모든 메서드의 조인 포인트를 선정, 부모 타입의 메서드도 적용
        @Around("execution(* me.minikuma.aop..*(..)) && @target(me.minikuma.aop.member.annotation.ClassAop)")
        public Object atTarget(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[@Target] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }

        // @Within: 선택된 클래스 내부에 있는 메서드만 조인 포인트로 사용, 부모 타입의 메서드는 적용되지 않음
        @Around("execution(* me.minikuma.aop..*(..)) && @within(me.minikuma.aop.member.annotation.ClassAop))")
        public Object atWithin(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[@Within] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

    @Autowired
    Child child;

    @Test
    void success() {
        log.info("child proxy = {}", child.getClass());
        child.childMethod();
        child.parentMethod();
    }

}