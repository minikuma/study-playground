package me.rp.sec05.quiz;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Question3 {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(finkSink -> {
            System.out.println("Created");
            for (int i = 0; i < 5; i++) {
                finkSink.next(i); // 0, 1, 2, 3, 4
            }
            finkSink.complete();
        });
        // filter = 2, 3, 4
        Flux<Integer> cache = flux.filter(i -> i > 1).cache(1);

        cache.subscribe(Util.subscriber());
        cache.subscribe(Util.subscriber());
    }
}
