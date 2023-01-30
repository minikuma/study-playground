package me.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 수량 관리 데이터 베이스
 */
public class InventoryService {
    private Map<String, Integer> db = new HashMap<>(); // map 형태의 db

    // 초기값 db 값 세팅
    public InventoryService() {
        db.put("Kids", 100);
        db.put("Automotive", 100);
    }

    // 컨슈머
    public Consumer<PurchaseOrder> subscriberOrderStream() {
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> v - p.getQuantity());
    }

    public Flux<String> inventoryStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString());
    }
}
