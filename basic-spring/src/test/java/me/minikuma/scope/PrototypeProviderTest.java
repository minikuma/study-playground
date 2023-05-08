package me.minikuma.scope;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeProviderTest {

    @Test
    @DisplayName("프로바이더를 사용한 빈 스코프 차이 해결")
    void providerTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int clientCount1 = clientBean1.logic();
        assertThat(clientCount1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int clientCount2 = clientBean2.logic();
        assertThat(clientCount2).isEqualTo(1);
    }

    @Component
    @Scope("singleton")
    static class ClientBean {
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeans;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeans.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Component
    @Scope("prototype")
    static class PrototypeBean {
        private int count  = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return this.count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init "  + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
