package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

/**
 * 컨트리 이름 데이터를 emitting
 * map 을 통해 String 으로 변환
 * handler = filter
 * canada 라는 나라이름이 나오면 Emitting 종료
 */
public class Lec02HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        }).map(Object::toString)
        .handle((s, synchronousSink) -> {
            synchronousSink.next(s);
            if (s.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        })
        .subscribe(Util.subscriber());
    }
}
