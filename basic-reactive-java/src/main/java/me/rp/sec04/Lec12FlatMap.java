package me.rp.sec04;

import me.rp.courseutil.Util;
import me.rp.sec04.helper.OrderService;
import me.rp.sec04.helper.UserService;

/**
 * FlatMap Demo
 */
public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
