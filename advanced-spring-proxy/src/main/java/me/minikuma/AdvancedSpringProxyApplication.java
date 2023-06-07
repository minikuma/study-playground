package me.minikuma;

import me.minikuma.config.AppV1Config;
import me.minikuma.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "me.minikuma.app")
public class AdvancedSpringProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedSpringProxyApplication.class, args);
    }

}
