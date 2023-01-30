package me.rp.sec05.quiz;

import reactor.core.publisher.Flux;

public class Question2 {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    System.out.println("Created");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i); // 0, 1, 2, 3, 4
                    }
                })
                .publish()
                .refCount(2);

        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
    }
}
