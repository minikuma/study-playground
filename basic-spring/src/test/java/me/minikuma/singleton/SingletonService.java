package me.minikuma.singleton;

public class SingletonService {
    private static volatile SingletonService INSTANCE = null;

    private SingletonService() {
        // Private Constructor
    }

    // double-checked
    public static SingletonService getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonService();
                }
            }
            logic();
        }
        return INSTANCE;
    }

    private static void logic() {
        System.out.println("싱글톤 로직 호출");
    }
}
