package me.minikuma.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
class ExecutionTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method method;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        method = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        log.info("helloMethod = {}", method);
    }

    @Test
    @DisplayName("표현식이 정확하게 일치하는 경우")
    void exactMatch() {
        pointcut.setExpression("execution(public String me.minikuma.aop.member.MemberServiceImpl.hello(String))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("가장 많이 생략하는 경우 (모든 조건 만족)")
    void allMatch() {
        pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("메서드 이름으로 매칭하는 것")
    void nameMatch() {
        pointcut.setExpression("execution(* hello(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("메서드 이름으로 매칭하는 것")
    void nameMatchStar() {
        pointcut.setExpression("execution(* hel*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("메서드 이름으로 매칭에 실패하는 경우")
    void nameMatchFalse() {
        pointcut.setExpression("execution(* nonono*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isFalse();
    }

    @Test
    @DisplayName("패키지 이름으로 정확하게 일치하는 경우")
    void packageExactMatch() {
        pointcut.setExpression("execution(* me.minikuma.aop.member.MemberServiceImpl.hello(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("패키지 이름으로 타입과 메서드를 (*)로 처리하는 경우")
    void packageExactMatchStar() {
        pointcut.setExpression("execution(* me.minikuma.aop.member.*.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("패키지 이름으로 타입과 메서드를 (*)로 처리하는 경우 - 실패케이스")
    void packageExactMatchStarFalse() {
        pointcut.setExpression("execution(* me.minikuma.aop.*.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isFalse();
    }

    @Test
    @DisplayName("패키지 이름과 그 하위 패키지를 포함하는 경우")
    void packageMatchSubPackage() {
        pointcut.setExpression("execution(* me.minikuma.aop.member..*.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("패키지 이름과 그 하위 패키지를 포함하는 경우(2)")
    void packageMatchSubPackage2() {
        pointcut.setExpression("execution(* me.minikuma.aop..*.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("타입 매칭")
    void typeExactMatch() {
        pointcut.setExpression("execution(* me.minikuma.aop.member.MemberServiceImpl.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("부모 타입 매칭")
    void typeExactSuperType() {
        pointcut.setExpression("execution(* me.minikuma.aop.member.MemberService.*(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("자식 타입에서만 선언된 메서드를 찾을 수 있을까? NO!")
    void typeMatchInternal() throws NoSuchMethodException {
        pointcut.setExpression("execution(* me.minikuma.aop.member.MemberService.*(..))");
        Method internalMethod = MemberServiceImpl.class.getMethod("internal", String.class);
        Assertions.assertThat(pointcut.matches(internalMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    @DisplayName("String 타입의 파라미터 매칭")
    void argsMatch() {
        pointcut.setExpression("execution(* *(String))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("파라미터가 없은 경우 매칭 (False) 파라미터가 있는데 없다고.")
    void argsMatchNoArgs() {
        pointcut.setExpression("execution(* *())");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isFalse();
    }

    @Test
    @DisplayName("정확하게 하나의 파라미터를 허용, 모든 타입 허용")
    void argsMatchStar() {
        pointcut.setExpression("execution(* *(*))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("숫자와 무관하게 모든 파라미터, 모든 타입 허용 (),(xxx), (xxx, xxx)")
    void argsMatchAll() {
        pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

    @Test
    @DisplayName("String으로 시작하면서 숫자와 무관하게 모든 파라미터, 모든 타입 허용 (String),(String, xxx), (String, xxx, xxx)")
    void argsMatchComplex() {
        pointcut.setExpression("execution(* *(String, ..))");
        Assertions.assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }
}