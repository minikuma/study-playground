package me.minikuma.discount;

import me.minikuma.member.Member;

public interface DiscountPolicy {
    // 회원 등급에 따라 달라지는 정책

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
