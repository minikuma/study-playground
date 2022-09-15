package me.rp.sec03;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.complete();
        })
        .subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
            String contry;
            // canada 라는 문자열이 나오면 이벤트 방출을 멈춘다.
            do {
                contry = Util.faker().country().name();
                fluxSink.next(contry);
            } while (!contry.toLowerCase().startsWith("canada"));

            fluxSink.complete();
        })
        .subscribe(Util.subscriber());
    }
}
