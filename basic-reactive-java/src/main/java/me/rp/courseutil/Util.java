package me.rp.courseutil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

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
            Thread.sleep(millisSeconds * 1000L);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }
    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }
}
