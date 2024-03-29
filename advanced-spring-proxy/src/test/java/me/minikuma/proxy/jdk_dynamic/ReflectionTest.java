package me.minikuma.proxy.jdk_dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    @Test
    void reflection0() {
        Hello target = new Hello();
        // 공통 로직 1 시작
        log.info("Start");
        String result1 = target.callA();
        log.info("result = {}", result1);
        // 공통 로직 1 종료

        // 공통 로직 2 시작
        log.info("Start");
        String result2 = target.callB();
        log.info("result = {}", result2);
        // 공통 로직 2 종료
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 클래스 정보 가져온다.
        Class<?> classHello = Class.forName("me.minikuma.proxy.jdk_dynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1 = {}", result1);

        // callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2 = {}", result2);
    }

    @Test
    void reflection2() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        // 클래스 정보 가져온다.
        Class<?> classHello = Class.forName("me.minikuma.proxy.jdk_dynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        // callA 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("Start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
