package me.minikuma._01_creational_patterns._01_singleton;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                MetaDataV5 mv1 = MetaDataV5.getInstance();
                System.out.println("객체 생성 : " + Thread.currentThread().getName() + " | " +mv1);
            });
        }

        executorService.shutdown();

        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println(LocalTime.now() + " 모든 Job 이 종료되었습니다.");
        } else {
            System.out.println(LocalTime.now() + " Job 이 아직 종료되지 않았습니다.");
        }
    }
}
