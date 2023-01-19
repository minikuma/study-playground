package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {
    public static void main(String[] args) {
        // Publisher
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                //.onErrorReturn(-1)
                //.onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {
                    // something
                })
                .subscribe(Util.subscriber())
        ;
    }

    /**
     *
     * @return Integer
     * fall back method
     */
    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }

}
