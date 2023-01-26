package me.rp.sec05;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublisher {
    public static void main(String[] args) {
        // share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1); // 데이터를 전달하기 위한 구독자 수

        movieStream
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        movieStream
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);
    }
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request!");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}