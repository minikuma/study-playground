package me.minikuma.item07.executor;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Thread thread = new Thread(new Task());
        // thread.start();

        int numberOfCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numberOfCpu);

//        for (int i = 0; i < 100; i++) {
//            service.submit(new Task());
//        }

        // Runnable 기본
        service.submit(new Task());

        // Callable 기본 (Future)
        Future<String> submit = service.submit(new CallTask());
        System.out.println(Thread.currentThread().getName() + " hello");

        System.out.println(submit.get()); // blocking 구간

        service.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " world");
        }
    }

    static class CallTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName() + " world";
        }
    }
}
