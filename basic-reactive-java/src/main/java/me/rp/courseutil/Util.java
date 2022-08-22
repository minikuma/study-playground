package me.rp.courseutil;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public final class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onCompleted() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int millisSeconds) {
        try {
            Thread.sleep(millisSeconds);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
