package me.minikuma;

import me.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class BasicSpringBootApplication {
    private final JdbcTemplate jdbcTemplate;

    public BasicSpringBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        this.jdbcTemplate.execute("create table if not exists members (name varchar(50) primary key, count int)");
    }

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
