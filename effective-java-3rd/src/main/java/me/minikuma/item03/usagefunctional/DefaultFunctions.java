package me.minikuma.item03.usagefunctional;

import me.minikuma.item03.methodreference.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "숫자 타입";
        System.out.println("Function :: " + intToString.apply(1));

        Supplier<Person> integerSupplier = Person::new;
        Function<LocalDate, Person> personFunction = Person::new;

        Consumer<Integer> integerConsumer = System.out::println;
        Predicate<Integer> predicate = (c) -> c > 10;
        System.out.println("Predicate :: " + predicate.test(1));
    }
}
