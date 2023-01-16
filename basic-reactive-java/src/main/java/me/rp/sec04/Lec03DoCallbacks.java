package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

/**
 * Callback Life Cycle 과 관련된 여러 메서드
 * (중요) 파이프라인 구조에서 Bottom 에서 Top 방향으로 실행된다.
 */
public class Lec03DoCallbacks {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    // fluxSink.complete();
                    fluxSink.error(new RuntimeException("Oops!"));
                    System.out.println("--completed");
                })
                .doOnComplete(() -> System.out.println("doOnCompleted"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext : " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe " + s))
                .doOnRequest(l -> System.out.println("doOnRequest " + l))
                .doOnError(err -> System.out.println("doOnError " + err.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doCancel"))
                .doFinally(signal -> System.out.println("doFinally : " + signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .take(2)
                .subscribe(Util.subscriber());
    }
}
