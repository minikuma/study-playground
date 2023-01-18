package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {

        // 기본 버퍼 사이즈: 32
        // 프로퍼티 재정의로 변경 가능
        System.setProperty("reactor.bufferSize.x", "9");

        // Publish 생성
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber())
        ;

        Util.sleepSeconds(60);
    }
}
