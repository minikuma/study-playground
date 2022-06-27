package me.minikuma.item03.staticfactory;

import java.util.function.Supplier;

/**
 * 공급자 (Supplier)
 */
public class Concert {
    public void start(Supplier<Singer> singerSupplier) {
        Singer singer = singerSupplier.get();
        singer.sing();
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        concert.start(Elvis::getInstance);
    }
}
