package me.rp.sec05.assignment;

import me.rp.courseutil.Util;

public class Lec06Assignment {
    public static void main(String[] args) {
        // 객체 생성
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.subscriberOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscriberOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
