package me.rp.sec06;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec06Parallel {

    static List<Integer> list = new ArrayList<>(); // thread-unsafe
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .parallel(10)
                .runOn(Schedulers.parallel())
                // .doOnNext(i -> printThreadName("next " + i))
                .subscribe(v -> list.add(v));

        Util.sleepSeconds(5);
        System.out.println(list.size());
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
