package me.minikuma.trace.template;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.template.code.AbstractTemplate;
import me.minikuma.trace.template.code.SubClassLogic1;
import me.minikuma.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    @Test
    @DisplayName("템플릿 메소드 패턴 - 상속 구조")
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    @DisplayName("템플릿 메소드 패턴 - 익명 클래스")
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직-1 실행");
            }
        };
        log.info("클래스 이름1 = {}", template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직-2 실행");
            }
        };
        log.info("클래스 이름2 = {}", template2.getClass());
        template2.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직-1 실행");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("경과 시간 = {}", elapsedTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직-2 실행");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("경과 시간 = {}", elapsedTime);
    }
}
