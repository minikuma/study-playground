package me.minikuma.proxy.advisor;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.proxy.common.service.Service;
import me.minikuma.proxy.common.service.ServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

class MultipleAdvisorTest {
    @Test
    @DisplayName("여러 프록시를 사용하는 경우")
    void multipleAdvisorTest1() {
        // client > proxy2(advisor2) > proxy1(advisor1) > target
        // proxy1 을 생성
        Service target = new ServiceImpl();
        ProxyFactory proxyFactory1 = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        proxyFactory1.addAdvisor(advisor1);
        Service proxy1 = (Service) proxyFactory1.getProxy();

        // proxy2 을 생성
        ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
        DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
        proxyFactory2.addAdvisor(advisor2);
        Service proxy2 = (Service) proxyFactory2.getProxy();

        proxy2.save();
    }

    @Test
    @DisplayName("하나의 프록시, 여러 어드바이저")
    void multipleAdvisorTest2() {
        DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
        // 프록시 1
        Service target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        proxyFactory.addAdvisor(advisor2);
        proxyFactory.addAdvisor(advisor1);

        Service proxy = (Service) proxyFactory.getProxy();

        proxy.save();
    }

    @Slf4j
    static class Advice1 implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advisor1 호출");
            return invocation.proceed();
        }
    }

    @Slf4j
    static class Advice2 implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advisor2 호출");
            return invocation.proceed();
        }
    }
}
