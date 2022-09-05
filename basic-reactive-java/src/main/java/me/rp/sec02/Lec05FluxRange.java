package me.rp.sec02;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

/**
 * Range
 *  - start, end 를 정해 놓고 1 씩 data 를 Emitting 할 수 있다. (Publishing)
 */
public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}
