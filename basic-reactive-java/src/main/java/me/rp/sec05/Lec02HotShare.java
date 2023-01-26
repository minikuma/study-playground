package me.rp.sec05;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share(); // hot share

        movieStream
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(5);

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
