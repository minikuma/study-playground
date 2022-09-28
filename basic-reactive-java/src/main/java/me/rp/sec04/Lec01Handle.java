package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        // handle = filter + map
        // emitting items
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer == 7) {
                        synchronousSink.complete();
                    } else {
                        if (integer % 2 == 0) {// even numbers filter
                            synchronousSink.next(integer);
                        } else {
                            synchronousSink.next(integer + "a"); // map
                        }
                    }
                })
                .subscribe(Util.subscriber());
    }
}
