package me.minikuma.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {
    @Test
    void lifecycleNetworkTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConnect_1.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Test
    void lifecycleAdvancedNetworkTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConnect_2.class);
        AdvancedNetworkClient client = ac.getBean(AdvancedNetworkClient.class);
        ac.close();
    }

    @Test
    void lifecycleAnnotationNetworkTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConnect_3.class);
        AnnotationNetworkClient client = ac.getBean(AnnotationNetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConnect_1 {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://spring.io");
            return networkClient;
        }
    }

    @Configuration
    static class LifeCycleConnect_2 {
        @Bean(initMethod = "init", destroyMethod = "close")
        public AdvancedNetworkClient advancedNetworkClient() {
            AdvancedNetworkClient advancedNetworkClient = new AdvancedNetworkClient();
            advancedNetworkClient.setUrl("https://advanced-spring.io");
            return advancedNetworkClient;
        }
    }

    @Configuration
    static class LifeCycleConnect_3 {
        @Bean
        public AnnotationNetworkClient annotationNetworkClient() {
            AnnotationNetworkClient annotationNetworkClient = new AnnotationNetworkClient();
            annotationNetworkClient.setUrl("https://annotation-spring.io");
            return annotationNetworkClient;
        }
    }
}
