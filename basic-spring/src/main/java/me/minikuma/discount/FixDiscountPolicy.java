package me.minikuma.discount;

import me.minikuma.member.Grade;
import me.minikuma.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // 정액 할인 조건: 회원등급이 VIP인 경우
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
