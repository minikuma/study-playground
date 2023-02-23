package me.minikuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {
}

class HelloServiceTest {
    @UnitTest
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String res = simpleHelloService.sayHello("Test");

        assertThat(res).isEqualTo("Hello Test");
    }

    @Test
    @DisplayName("Decorator Test")
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String ret = helloDecorator.sayHello("Test");
        assertThat(ret).isEqualTo("*Test*");
    }
}