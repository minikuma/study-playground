package me.minikuma.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

class ProviderTest {
    @Test
    @DisplayName("Provider 인터페이스를 활용하여 DL 테스트 (JSR 330)")
    void providerTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean cb = ac.getBean(ClientBean.class);
        int countClientBean = cb.logic();
        System.out.println("countClientBean = " + countClientBean);

        ClientBean pb = ac.getBean(ClientBean.class);
        int count = pb.logic();
        System.out.println("count = " + count);
        Assertions.assertThat(countClientBean).isEqualTo(count);
    }

    @Component
    @Scope(SCOPE_SINGLETON)
    static class ClientBean {
        @Autowired
        private Provider<PrototypeBean> prototypeBean;

        public int logic() {
            PrototypeBean prototypeBean = this.prototypeBean.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Component
    @Scope(SCOPE_PROTOTYPE)
    static class PrototypeBean {
        private int count = 0;

        // add count
        public void addCount() {
            this.count++;
        }

        // 조회
        public int getCount() {
            return this.count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
