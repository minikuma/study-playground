package me.minikuma.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
class WithinTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method method;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        method = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    @DisplayName("표현식이 정확하게 일치하는 경우")
    void withinExact() {
        pointcut.setExpression("within(me.minikuma.aop.member.MemberServiceImpl)");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("within 표현식 - * 처리")
    void  withinStar() {
        pointcut.setExpression("within(me.minikuma.aop.member.*Service*)");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("within 표현식 - 하위 패키지 포함")
    void withinSubPackage() {
        pointcut.setExpression("within(me.minikuma.aop..*)");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("within 표현식 - 타입의 타켓에만 적용 가능 - 인터페이스 적용 X")
    void withinSuperTypeFalse() {
        pointcut.setExpression("within(me.minikuma.aop.member.MemberService)");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isFalse();
    }

    @Test
    @DisplayName("execution 은 티입 기반, 인터페이스 적용 가능")
    void withinSuperTypeTrue() {
        pointcut.setExpression("execution(* me.minikuma.aop.member.MemberService.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }
}