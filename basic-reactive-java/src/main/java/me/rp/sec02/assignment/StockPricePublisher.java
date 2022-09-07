package me.rp.sec02.assignment;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *   publisher 의 조건
 *   - 1초 간격으로 데이터 송신
 *   - 5 ~ 5 랜덤 수 발생해서 두 수의 합을 계산
 *   - 가격은 0 달러부터 100달러까지만 허용됨
 */
public class StockPricePublisher {
    public static Flux<Integer> getPrice() {
        // 달러
        AtomicInteger atomicInteger = new AtomicInteger(100);

        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        (x, y) -> x + y
                ));
    }
}
