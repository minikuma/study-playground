package me.minikuma.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.strategy.code.ContextV2;
import me.minikuma.trace.strategy.code.Strategy;
import me.minikuma.trace.strategy.code.StrategyLogic1;
import me.minikuma.trace.strategy.code.StrategyLogic2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ContextV2Test {
    @Test
    @DisplayName("전략 패턴 - 파라미터 전략 전달")
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    @Test
    @DisplayName("전략 패턴 - 파라미터 전략 전달(익명 내부 클래스)")
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 - 1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 - 2 실행");
            }
        });
    }

    @Test
    @DisplayName("전략 패턴 - 파라미터 전략 전달(람다)")
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직 - 1 실행"));
        context.execute(() -> log.info("비즈니스 로직 - 2 실행"));
    }
}
