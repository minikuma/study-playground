package me.minikuma.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        basePackages = "me.minikuma",
        excludeFilters = @Filter(type = ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
