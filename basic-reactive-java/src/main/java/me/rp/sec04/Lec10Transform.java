package me.rp.sec04;

import me.rp.courseutil.Util;
import me.rp.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Customized Operators
 */
public class Lec10Transform {
    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(p -> new Person());
    }

    // customized function
    // 조건: age 가 10 이상이면, 이름을 대문자로 변환
    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing : " + p));
    }
}
