package me.minikuma.item07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        CustomObject customObject = new CustomObject();
        SoftReference<Object> soft = new SoftReference<>(customObject);
        customObject = null; // 참조 해지

        // gc 실행
        System.gc();
        Thread.sleep(3000L);

        // soft reference 는 gc에 의해 정리되지 않음 (메모리가 부족한 경우에만 정리됨)
        System.out.println(soft.get());
    }
}
