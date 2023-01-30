package me.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 가격 관리 데이터 베이스
 */
public class RevenueService {

    private Map<String, Double> db = new HashMap<>();

    // 초기값 세팅
    public RevenueService() {
        db.put("Kids", 0.0);
        db.put("Automotive", 0.0);
    }

    public Consumer<PurchaseOrder> subscriberOrderStream() {
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> v + p.getPrice());
    }

    public Flux<String> revenueStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString());
    }
}
