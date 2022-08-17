package me.rp.courseutil;

import java.util.function.Consumer;

public final class Util {
    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onCompleted() {
        return () -> System.out.println("Completed");
    }
}
