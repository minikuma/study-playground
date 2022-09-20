package me.rp.sec03;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {

        // canada 가 나오는 경우 - completed
        // maximum item = 10
        // subscriber cancels - exit

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
                    System.out.println("Emitting : " + country);
                    synchronousSink.next(country);
                    atomicInteger.incrementAndGet();
                    // check
                    if (country.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }
        })
        .subscribe(Util.subscriber());
    }
}
