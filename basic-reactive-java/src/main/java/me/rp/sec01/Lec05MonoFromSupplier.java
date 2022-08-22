package me.rp.sec01;

import me.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * 구독하지 않은 경우 메소드 실행을 하지 않게 구현 가능하다.
 */

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        // 데이터가 존재할 때 사용가능하다.
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(() -> getName());

        // supplier 는 구독시점에 데이터를 가져올수 있다. (Lazy 효과)
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onCompleted()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
