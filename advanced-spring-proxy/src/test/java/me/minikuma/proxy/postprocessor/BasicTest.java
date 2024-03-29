package me.minikuma.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BasicTest {
    @Test
    void basicConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BasicConfig.class);

        // A는 빈으로 등록
        A a = context.getBean("beanA", A.class);
        a.helloA();

        // B는 빈으로 등록되지 않는다.
        Assertions.assertThatThrownBy(() ->
                        context.getBean("beanB", B.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @Slf4j
    @Configuration
    static class BasicConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }
}
