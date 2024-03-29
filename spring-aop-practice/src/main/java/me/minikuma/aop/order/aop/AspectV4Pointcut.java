package me.minikuma.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV4Pointcut {
    @Around("me.minikuma.aop.order.aop.Pointcuts.allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        // 리얼 객체 호출
        return joinPoint.proceed();
    }

    // me.minikuma.aop.order 패키지와 하위 패키지이면서 클래스 이름이 *Service 인 것
    @Around("me.minikuma.aop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[트랜젝션 시작] :: {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[트랜젝션 커밋] :: {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("[트랜젝션 롤백] :: {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("[트랜젝션 리소스 릴리즈] :: {}", joinPoint.getSignature());
        }
    }
}
