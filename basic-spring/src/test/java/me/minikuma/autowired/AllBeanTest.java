package me.minikuma.autowired;

import me.minikuma.config.AutoAppConfig;
import me.minikuma.discount.DiscountPolicy;
import me.minikuma.member.Grade;
import me.minikuma.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AllBeanTest {
    @Test
    @DisplayName("클라이언트에서 할인율을 정해서 호출하는 경우(동적으로 빈을 생성해야 하는 경우")
    void findAllBeans() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> discountPolicyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> discountPolicyList) {
            this.policyMap = policyMap;
            this.discountPolicyList = discountPolicyList;
            System.out.println(policyMap);
            System.out.println(discountPolicyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
