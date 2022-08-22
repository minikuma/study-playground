package me.rp.sec01;

import me.rp.courseutil.Util;
import reactor.core.publisher.Mono;

/**
 * 알림이 필요할 때 Runnable
 */
public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done, Sending emails...");
                        }
                );
    }
    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3000);
            System.out.println("Operation Completed...");
        };
    }
}
