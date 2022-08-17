package me.rp.sec01;

import reactor.core.publisher.Mono;

/**
 * Mono Just
 */
public class Lec02MonoJust {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        // Subscriber
        mono.subscribe(i -> System.out.println("Received : " + i));
    }
}
