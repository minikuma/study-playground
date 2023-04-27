package me.minikuma.scan;

import me.minikuma.config.AutoAppConfig;
import me.minikuma.member.MemberService;
import me.minikuma.member.MemberServiceImpl;
import me.minikuma.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AutoAppConfigTest {
    @Test
    void basicComponentScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        System.out.println(ac);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        System.out.println(orderService);
    }
}
