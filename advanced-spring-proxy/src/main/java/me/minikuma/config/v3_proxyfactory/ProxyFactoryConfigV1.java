package me.minikuma.config.v3_proxyfactory;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.app.v1.*;
import me.minikuma.config.v3_proxyfactory.advice.LogTraceAdvice;
import me.minikuma.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV1 {
    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        // target
        OrderControllerV1 orderController = new OrderControllerV1Impl(orderServiceV1(logTrace));

        // proxy factory
        ProxyFactory proxyFactory = new ProxyFactory(orderController);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        // proxy factory > proxy
        OrderControllerV1 proxy = (OrderControllerV1) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderController.getClass());

        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        // target
        OrderServiceV1 orderService = new OrderServiceV1Impl(orderRepositoryV1(logTrace));

        // proxy factory
        ProxyFactory proxyFactory = new ProxyFactory(orderService);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        // proxy factory > proxy 생성
        OrderServiceV1 proxy = (OrderServiceV1) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderService.getClass());

        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV1Impl orderRepository = new OrderRepositoryV1Impl();

        ProxyFactory factory = new ProxyFactory(orderRepository);
        factory.addAdvisor(getAdvisor(logTrace));

        OrderRepositoryV1 proxy = (OrderRepositoryV1) factory.getProxy();

        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderRepository.getClass());

        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        // 포인트 컷
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        // 어드바이스
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
