package me.minikuma.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV2 {

    // me.minikuma.aop.order 패키지와 하위 패키지
    @Pointcut("execution(* me.minikuma.aop.order..*(..))")
    private void allOrder() {
        // pointcut signature
    }

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        // 리얼 객체 호출
        return joinPoint.proceed();
    }
}
