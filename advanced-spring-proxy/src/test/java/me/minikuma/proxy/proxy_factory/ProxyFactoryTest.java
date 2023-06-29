package me.minikuma.proxy.proxy_factory;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.proxy.common.advice.TimeAdvice;
import me.minikuma.proxy.common.service.Service;
import me.minikuma.proxy.common.service.ServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
class ProxyFactoryTest {
    @Test
    @DisplayName("인터페이스가 있으면 JDK 프록시 사용")
    void interfaceProxy() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        Service proxy = (Service) proxyFactory.getProxy();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.save();

        Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        Assertions.assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
        Assertions.assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }
}
