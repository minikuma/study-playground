package me.minikuma.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략 구현체를 파라마터로 받는 형태
 */
@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("elapsed time = {}", elapsedTime);
    }
}
