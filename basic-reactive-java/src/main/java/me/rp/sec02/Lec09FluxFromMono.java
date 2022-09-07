package me.rp.sec02;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
//        Mono<String> mono = Mono.just("a");
//        Flux<String> flux = Flux.from(mono); // convert to mono
//
//        flux.subscribe(Util.onNext());
//
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()// 1 (emit limited)
                .subscribe(Util.onNext(), Util.onError(), Util.onCompleted());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
