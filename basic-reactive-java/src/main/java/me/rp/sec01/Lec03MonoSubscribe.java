package me.rp.sec01;

import me.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(s -> s.length())
                        .map(l -> l / 1);

        // 1
        mono.subscribe();

        // 2
//        mono.subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Completed")
//        );
        // Util method 로 추출
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onCompleted()
        );
    }
}
