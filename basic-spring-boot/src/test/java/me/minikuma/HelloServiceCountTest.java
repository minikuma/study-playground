package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@BasicBootTest
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    // @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;
    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("minikuma");
            Assertions.assertThat(helloRepository.countOf("minikuma")).isEqualTo(count);
        });
    }
}
