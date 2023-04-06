package me.minikuma.order;

import me.minikuma.discount.DiscountPolicy;
import me.minikuma.discount.FixDiscountPolicy;
import me.minikuma.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    @Test
    @DisplayName("주문하기")
    void order() {
        // given
        // (1) 가입된 회원
        Member member = new Member(1L, "memberB", Grade.VIP);
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MeberServiceImpl(memberRepository);
        DiscountPolicy discountPolicy = new FixDiscountPolicy();
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        // when
        Order order = orderService.createOrder(findMember.getId(), "productA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order.calculatorPrice()).isEqualTo(9000);
    }
}