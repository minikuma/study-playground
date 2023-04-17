package me.minikuma.beanfind;

import me.minikuma.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationContextInfoTest extends GenericApplicationContext {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            Object beanName = ac.getBean(bean);
            System.out.println("Bean Name :: " + bean + " | Bean Object ::" + beanName);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(bean);

            // 애플리케이션 빈 필터링
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object beanName = ac.getBean(bean);
                System.out.println("Bean Name :: " + bean + " | Bean Object ::" + beanName);
            }
        }
    }
}
