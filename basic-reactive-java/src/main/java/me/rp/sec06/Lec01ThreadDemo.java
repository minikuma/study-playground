package me.rp.sec06;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("Created");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next " + i));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub " + v));

        // 2개의 스레드 생성 (2개의 subscriber)
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    // 현재 스레드 출력
    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
