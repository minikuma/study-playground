package me.minikuma.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ArgsTest {
    Method method;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        method = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    private AspectJExpressionPointcut pointcut(String expression) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        return pointcut;
    }

    @Test
    @DisplayName("args 표현식 테스트")
    void args() {
        // hello(String) 매칭
        assertThat(pointcut("args(String)").matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args(Object)").matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args()").matches(method, MemberServiceImpl.class)).isFalse();
        assertThat(pointcut("args(..)").matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args(*)").matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args(String, ..)").matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("args vs execution 차이점")
    void argsVsExecution() {
        // Args
        assertThat(pointcut("args(String)")
                .matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args(java.io.Serializable)")
                .matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("args(Object)")
                .matches(method, MemberServiceImpl.class)).isTrue();

        // Execution
        assertThat(pointcut("execution(* *(String))")
                .matches(method, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("execution(* *(java.io.Serializable))")
                .matches(method, MemberServiceImpl.class)).isFalse();
        assertThat(pointcut("execution(* *(Object))")
                .matches(method, MemberServiceImpl.class)).isFalse();
    }
}