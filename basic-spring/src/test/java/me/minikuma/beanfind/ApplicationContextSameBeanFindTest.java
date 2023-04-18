package me.minikuma.beanfind;

import me.minikuma.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("타입 조회 시, 같은 타입이 둘 이상이면 중복 오류가 발생한다.")
    void findBeanByTypeDuplication() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }

    @Test
    @DisplayName("타입 조회 시, 같은 타입이 있는 경우 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository1 = ac.getBean("memberRepository1", MemberRepository.class);
        MemberRepository memberRepository2 = ac.getBean("memberRepository2", MemberRepository.class);
        assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
        assertThat(memberRepository2).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
            Assertions.assertThat(beansOfType.get(key)).isInstanceOf(MemberRepository.class);
        }
        System.out.println("bean type = " + beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
