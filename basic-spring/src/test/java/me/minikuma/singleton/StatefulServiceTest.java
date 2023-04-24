package me.minikuma.singleton;

import me.minikuma.beanfind.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    @DisplayName("상태를 가지고 있는 필드를 가지고 있는 경우 싱글톤의 문제 발생")
    void statefulServiceSingletonBean() throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName() + " | ");
                statefulService1.order("User A", 10000);
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName() + " | ");
                statefulService2.order("User B", 20000);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task1).start();
            new Thread(task2).start();
            Thread.sleep(1000);
            int price = statefulService1.getPrice();
            System.out.println("price = " + price);
        }

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
}