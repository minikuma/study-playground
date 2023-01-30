package me.rp.sec05.quiz;

import reactor.core.publisher.Flux;

public class Question1 {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("Created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i); // 0,1,2,3,4
            }
        });

        Flux<Integer> map = flux.map(i -> i * 2); // 0, 2, 4, 6, 8

        map.subscribe(System.out::println);
        map.subscribe(System.out::println);
    }
}
