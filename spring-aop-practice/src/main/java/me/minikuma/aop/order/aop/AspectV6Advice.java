package me.minikuma.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

/*
    @Around("me.minikuma.aop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // @Before
            log.info("[트랜젝션 시작] :: {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[트랜젝션 커밋] :: {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            // @AfterThrowing
            log.info("[트랜젝션 롤백] :: {}", joinPoint.getSignature());
            throw e;
        } finally {
            // @After
            log.info("[트랜젝션 리소스 릴리즈] :: {}", joinPoint.getSignature());
        }
    }*/

    @Before("me.minikuma.aop.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[Before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "me.minikuma.aop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        log.info("[Return] {} return = {}", joinPoint.getSignature(), result);
    }

    @AfterReturning(value = "me.minikuma.aop.order.aop.Pointcuts.allOrder()", returning = "result")
    public void doReturn2(JoinPoint joinPoint, String result) {
        log.info("[Return2] {} return2 = {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "me.minikuma.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[ex] {} message = {}",  ex);
    }

    @After(value = "me.minikuma.aop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[After] {}", joinPoint.getSignature());
    }
}
