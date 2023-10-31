package me.minikuma.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class UnCheckedTest {

    @Test
    @DisplayName("언체크 에러 잡는 경우")
    void unchecked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    @DisplayName("언체크 에러 던지는 경우")
    void unchecked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyUncheckedException.class);
    }

    /**
     * RuntimeException 을 상속 받게 되면 언체크 예외
     */
    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    /**
     * 언체크 예외는 예외를 잡거나 던지지 않아도 됨
     * 예외를 잡지 않으면 자동으로 던짐
     */
    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                log.error("예외 처리, messages = {}", e.getMessage(), e);
            }
        }

        public void callThrow() {
            repository.call();
        }
    }

    static class Repository {
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }
}
