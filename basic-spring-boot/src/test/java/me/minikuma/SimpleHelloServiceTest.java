package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleHelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String res = simpleHelloService.sayHello("Test");

        assertThat(res).isEqualTo("Hello Test");
    }
}