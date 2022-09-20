package me.rp.sec03;

import me.rp.courseutil.Util;
import me.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

/**
 * Flux Push - Thread Safe 하지 않음
 */
public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
