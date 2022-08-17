package me.rp.sec01;

import java.util.stream.Stream;

/**
 * Stream Interface
 */
public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    return i * 2;
                });
        // System.out.println(stream);
        stream.forEach(i -> {
            System.out.println(i);
        });
    }
}
