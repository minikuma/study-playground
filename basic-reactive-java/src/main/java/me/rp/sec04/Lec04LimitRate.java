package me.rp.sec04;

import me.rp.courseutil.Util;
import reactor.core.publisher.Flux;

/**
 * Limit Rate
 */
public class Lec04LimitRate {

    public static void main(String[] args) {
        // publisher
        Flux.range(1, 1000)
                .log()
                .limitRate(100) // 설정된 비율의 75% 씩 완료 후 다시 업스트림에 요청
                .subscribe(Util.subscriber())
        ;

        /*
            low tide: 0 인 경우, high tide 만큼 배치되는 데이터 양을 조절함
        * */
        Flux.range(1, 100)
                .log()
                .limitRate(10, 0)
                .subscribe(Util.subscriber())
        ;
    }
}
