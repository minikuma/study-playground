package me.minikuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        // SimpleHelloService simpleHelloService = new SimpleHelloService();
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid Parameter");
        }
        return helloService.sayHello(name);
    }
}
