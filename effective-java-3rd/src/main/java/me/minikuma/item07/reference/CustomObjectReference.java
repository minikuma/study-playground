package me.minikuma.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class CustomObjectReference<CustomObject> extends PhantomReference<CustomObject> {
    public CustomObjectReference(CustomObject referent, ReferenceQueue<? super CustomObject> q) {
        super(referent, q);
    }

    // 재정의 자원 반납 용
    public void cleanUp() {
        System.out.println("Clean Up");
    }
}
