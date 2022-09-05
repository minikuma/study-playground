package me.rp.sec02;

import me.rp.courseutil.Util;
import me.rp.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxList {
    public static void main(String[] args) {
        // 5명의 이름을 가져온다.
        //List<String> names = NameGenerator.getNames(5);
        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
