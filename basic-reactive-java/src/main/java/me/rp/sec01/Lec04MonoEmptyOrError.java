package me.rp.sec01;

import me.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(20)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onCompleted()
                );
    }

    // Publisher 역할
    private static Mono<String> userRepository(int userId) {
        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // no data (null 인 경우)
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
