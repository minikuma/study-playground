package me.rp.sec05;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublisherCache {
    public static void main(String[] args) {
        // cache = publish().replay() > int.max (이력저장공간)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(2);

        Util.sleepSeconds(2);

        movieStream
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

        movieStream
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(10);
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
