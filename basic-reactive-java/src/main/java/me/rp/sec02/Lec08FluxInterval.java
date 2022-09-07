package me.rp.sec02;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * 일정 주기로 Data Push
 */

public class Lec08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);

    }
}
