package me.rp.sec03;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        // Only one instance of FluxSink
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting : " + country);
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
        .take(3)
        .subscribe(Util.subscriber());
    }
}
