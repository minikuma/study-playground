package me.minikuma.item07.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        CustomObject strong = new CustomObject();
        // 참조를 관리하는 큐
        ReferenceQueue<CustomObject> rq = new ReferenceQueue<>();

        CustomObjectReference<CustomObject> phantom = new CustomObjectReference<>(strong, rq);
        //PhantomReference<CustomObject> phantom = new PhantomReference<>(strong, rq);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(phantom.isEnqueued()); // queue 에 존재하면 자원 반납

        Reference<? extends CustomObject> reference = rq.poll();
        CustomObjectReference clean = (CustomObjectReference) reference;
        clean.cleanUp(); // 자원 반납
        reference.clear(); // phantom reference 정리
    }
}
