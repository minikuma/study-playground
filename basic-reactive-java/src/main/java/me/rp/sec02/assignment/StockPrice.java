package me.rp.sec02.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * Subscriber 조건
 *  - 업데이트 되는 가격정보를 조회(Observe)
 *  - 가격이 90 ~ 110 가격만 선택적으로 확인
 */
public class StockPrice {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                        this.subscription = subscription;
                    }

                    @Override
                    public void onNext(Integer price) {
                        if (price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                        System.out.println(LocalDateTime.now() + " : Price : " + price);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });
        latch.await();
    }
}
