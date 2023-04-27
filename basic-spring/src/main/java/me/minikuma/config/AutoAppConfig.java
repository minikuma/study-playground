package me.minikuma.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.ComponentScan.*;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //TODO: 재 테스트 필요
}
