package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 11);
    }

    // fallback
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
