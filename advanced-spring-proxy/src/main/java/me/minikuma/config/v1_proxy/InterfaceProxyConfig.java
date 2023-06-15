package me.minikuma.config.v1_proxy;

import me.minikuma.app.v1.*;
import me.minikuma.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import me.minikuma.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import me.minikuma.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import me.minikuma.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl orderControllerImpl= new OrderControllerV1Impl(orderService(logTrace));
        // proxy 를 반환
        return new OrderControllerInterfaceProxy(orderControllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl orderRepositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryImpl, logTrace);
    }
}
