package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http://localhost:8080?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // status : 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header (Content-Type): text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body: Hello Spring
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();

        Assertions.assertThatThrownBy(() -> {
            ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}