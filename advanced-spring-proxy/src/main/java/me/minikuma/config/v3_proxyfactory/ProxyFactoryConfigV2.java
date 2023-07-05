package me.minikuma.config.v3_proxyfactory;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.app.v2.OrderControllerV2;
import me.minikuma.app.v2.OrderRepositoryV2;
import me.minikuma.app.v2.OrderServiceV2;
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
public class ProxyFactoryConfigV2 {
    @Bean
    public OrderControllerV2 orderControllerV1(LogTrace logTrace) {
        // target
        OrderControllerV2 orderController = new OrderControllerV2(orderServiceV2(logTrace));

        // proxy factory
        ProxyFactory proxyFactory = new ProxyFactory(orderController);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        // proxy factory > proxy
        OrderControllerV2 proxy = (OrderControllerV2) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderController.getClass());

        return proxy;
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        // target
        OrderServiceV2 orderService = new OrderServiceV2(orderRepositoryV2(logTrace));

        // proxy factory
        ProxyFactory proxyFactory = new ProxyFactory(orderService);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        // proxy factory > proxy 생성
        OrderServiceV2 proxy = (OrderServiceV2) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderService.getClass());

        return proxy;
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 orderRepository = new OrderRepositoryV2();

        ProxyFactory factory = new ProxyFactory(orderRepository);
        factory.addAdvisor(getAdvisor(logTrace));

        OrderRepositoryV2 proxy = (OrderRepositoryV2) factory.getProxy();

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
