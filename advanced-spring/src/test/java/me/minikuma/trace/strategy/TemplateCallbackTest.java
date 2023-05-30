package me.minikuma.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.strategy.code.template.Callback;
import me.minikuma.trace.strategy.code.template.TimeLogTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class TemplateCallbackTest {
    @Test
    @DisplayName("템플릿 콜백 - 익명 내부 클래스")
    void callbackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 - 1 실행");
            }
        });

        timeLogTemplate.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 - 2 실행");
            }
        });
    }

    @Test
    @DisplayName("템플릿 콜백 - 람다")
    void callbackV2() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("비즈니스 로직 - 1 실행"));
        timeLogTemplate.execute(() -> log.info("비즈니스 로직 - 2 실행"));
    }
}
