package me.minikuma;

import me.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class BasicSpringBootApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name: " + name);
        };
    }

    public static void main(String[] args) {
        // Spring Container 생성
        //MySpringApplication.run(BasicSpringBootApplication.class, args);
        SpringApplication.run(BasicSpringBootApplication.class, args);
    }
}
