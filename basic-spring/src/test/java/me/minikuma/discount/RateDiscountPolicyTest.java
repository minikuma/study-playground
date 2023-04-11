package me.minikuma.discount;

import me.minikuma.member.Grade;
import me.minikuma.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 한다.")
    void vip_ok() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되면 안된다.")
    void vip_not_ok() {
        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isZero();
    }
}