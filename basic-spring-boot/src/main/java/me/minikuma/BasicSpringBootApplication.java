package me.minikuma;

import me.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class BasicSpringBootApplication {
    public static void main(String[] args) {
        // Spring Container 생성
        //MySpringApplication.run(BasicSpringBootApplication.class, args);
        SpringApplication.run(BasicSpringBootApplication.class, args);
    }
}
