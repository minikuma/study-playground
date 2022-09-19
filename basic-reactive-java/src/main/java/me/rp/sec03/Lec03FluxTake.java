package me.rp.sec03;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        // map

        // filter
        Flux.range(1, 10)
                .log()
                .take(3) // 정한 개수만 받을 수 있음
                .log()
                .subscribe(Util.subscriber());
    }
}
