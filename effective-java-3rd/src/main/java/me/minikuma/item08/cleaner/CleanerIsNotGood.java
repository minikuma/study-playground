package me.minikuma.item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {
    public static void main(String[] args) throws InterruptedException {
        Cleaner cleaner = Cleaner.create(); // cleaner 생성

        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp);

        // cleaner 등록
        cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

        bigObject = null;

        System.gc();
        Thread.sleep(3000L);
    }
}
