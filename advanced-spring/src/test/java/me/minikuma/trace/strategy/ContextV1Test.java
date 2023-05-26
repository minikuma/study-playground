package me.minikuma.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.strategy.code.ContextV1;
import me.minikuma.trace.strategy.code.Strategy;
import me.minikuma.trace.strategy.code.StrategyLogic1;
import me.minikuma.trace.strategy.code.StrategyLogic2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ContextV1Test {
    @Test
    @DisplayName("전략 패턴 - 일반 케이스")
    void strategyV0() {
        logic1();
        logic2();
    }

    @Test
    @DisplayName("전략 패턴 - 인터페이스 도입")
    void StrategyV1() {
        ContextV1 context1 = new ContextV1(new StrategyLogic1());
        context1.execute();

        ContextV1 context2 = new ContextV1(new StrategyLogic2());
        context2.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 - 1 실행");
        long endTime = System.currentTimeMillis();
        log.info("elapsed time = {}", endTime - startTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 - 2 실행");
        long endTime = System.currentTimeMillis();
        log.info("elapsed time = {}", endTime - startTime);
    }
}
