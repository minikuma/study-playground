package me.minikuma.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class CheckedTest {

    @Test
    @DisplayName("체크예외를 잡아서 처리한다.")
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    @DisplayName("체크예외를 던진다.")
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyCheckedException.class);
    }

    /**
     * Exception 을 상속 받았기 때문에 체크 예외로 동작
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    /**
     * 예외를 잡거나, 던지거나 둘 중에 선택해야 함
     */
    static class Service {
        Repository repository = new Repository();

        /**
         * 예외를 잡아서 처리 하는 경우
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                // 예외를 처리
                log.error("예외 처리, messages = {}", e.getMessage(), e);
            }
        }

        /**
         * 체크 예외를 나를 호출한 쪽으로 던진다.
         * @throws MyCheckedException
         */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }
}
