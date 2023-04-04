package me.minikuma.item07.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        CustomObject strong = new CustomObject();
        WeakReference<Object> weak = new WeakReference<>(strong);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // weak reference 는 gc 로 정리됨
        System.out.println(weak.get());
    }
}
