package me.minikuma.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Person {
    LocalDate birthDay;

    public Person() {

    }

    public Person(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public static int compareByAge(Person p1, Person p2) {
        return p1.birthDay.compareTo(p2.birthDay);
    }

    public int compareByAgeInstance(Person p1, Person p2) {
        return p1.birthDay.compareTo(p2.birthDay);
    }

    public int compareByAgeInstanceObject(Person p) {
        return this.birthDay.compareTo(p.birthDay);
    }

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1999, 7, 1));
        dates.add(LocalDate.of(1999, 8, 1));
        dates.add(LocalDate.of(1999, 9, 1));

        // (4) 생성자 레퍼런스 (매개변수 존재하는 경우)
        Function<LocalDate, Person> aNew = Person::new;
        dates.stream()
                .map(aNew)
                .collect(Collectors.toList());

        Supplier<Person> aaNew = Person::new;

        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1999, 7, 1)));
        people.add(new Person(LocalDate.of(1985, 11, 15)));
        people.add(new Person(LocalDate.of(1990, 3, 9)));
        // 람다 표현식
        people.sort((o1, o2) -> o1.birthDay.compareTo(o2.birthDay));
        // (1) 스태틱 메소드 레퍼런스
        people.sort(Person::compareByAge);

        // (2) 인스턴스 메소드 레퍼런스
        Person person = new Person(null); // 인스턴스
        people.sort(person::compareByAgeInstance);

        // (3) 임의 객체의 인스턴스 메소드 레퍼런스
        people.sort(Person::compareByAgeInstanceObject); // 자기 자신(this)과 비교
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDay.getYear();
    }
}
