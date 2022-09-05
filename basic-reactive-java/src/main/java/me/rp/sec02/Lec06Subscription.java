package me.rp.sec02;

import me.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Customized Subscription 을 구현해서 사용할 수 있음
 * - 구독 취소가 가능
 * - 원하는 만큼 데이터를 가져올 수 있음
 */
public class Lec06Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        // publisher
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Subscription : " + subscription);
                        atomicReference.set(subscription); // subscription 등록
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("On Next : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onCompleted");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);

        Util.sleepSeconds(5);
        atomicReference.get().request(3);

        Util.sleepSeconds(5);
        System.out.println("Going to Cancel");
        atomicReference.get().cancel();

        Util.sleepSeconds(3);
        atomicReference.get().request(4);

        Util.sleepSeconds(3);
    }
}
