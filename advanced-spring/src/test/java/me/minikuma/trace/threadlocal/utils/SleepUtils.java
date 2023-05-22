package me.minikuma.trace.threadlocal.utils;

public class SleepUtils {

    private SleepUtils() {

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
