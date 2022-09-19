package me.rp.sec03;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        // 새로운 객체를 생성한다.
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting");
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
        })
        .take(2)
        .subscribe(Util.subscriber());
    }
}
