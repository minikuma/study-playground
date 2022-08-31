package me.rp.sec02;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import javax.swing.event.MouseInputListener;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        //stream.forEach((i) -> System.out.println(i)); // closed
        //stream.forEach((i) -> System.out.println(i));

        /**
         * (1) Stream 인 경우
         * (2) Supplier 인 경우
         */
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onCompleted()
        );

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onCompleted()
        );
    }
}
