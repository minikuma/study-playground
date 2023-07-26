package me.minikuma.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * Aspect 는 순서 보장이 안됨
 * 순서를 하려면?
 *  그냥 Order Annotation 적용? > 적용 안됨
 *  Aspect 단위로 순서를 지정할 수 있다. 결국 Aspect 를 붙일 수 있는 단위 = 클래스 단위
 */
@Slf4j
public class AspectV5Order {
    @Aspect
    @Order(2)
    public static class LogAspect {
        @Around("me.minikuma.aop.order.aop.Pointcuts.allOrder()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[log] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(1)
    public static class TxAspect {
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
}
