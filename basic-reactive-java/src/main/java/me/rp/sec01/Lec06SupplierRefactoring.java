package me.rp.sec01;

import me.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        // not blocking! (pipeline)
        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic()) // non-blocking
                .block();// blocking
        System.out.println(name);
        getName();

        Util.sleepSeconds(4000);

    }

    private static Mono<String> getName() {
        System.out.println("Entered getName Method");
        return Mono.fromSupplier(() -> {
            // biz logic
            System.out.println("Generating name...");
            Util.sleepSeconds(3000);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
