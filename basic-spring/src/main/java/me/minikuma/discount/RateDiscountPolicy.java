package me.minikuma.discount;

import me.minikuma.member.Grade;
import me.minikuma.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    /**
     *
     * @param member
     * @param price
     * @return 할인금액
     */
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
