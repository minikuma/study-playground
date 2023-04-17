package me.minikuma.member;

import me.minikuma.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceTest {
    MemberService memberService;
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @BeforeEach
    void init() {
//        AppConfig config = new AppConfig();
//        memberService = config.memberService();
        this.memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    @DisplayName("회원을 가입한다.")
    void member_join() {
        // given
        // MemberRepository memberRepository = new MemoryMemberRepository();
        // MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member = new Member(1L, "memberA", Grade.VIP);

        // 회원 가입
        this.memberService.join(member);

        // 가입된 회원 찾기
        Member savedMember = this.memberService.findMember(member.getId());

        // then
        Assertions.assertThat(savedMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(savedMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(savedMember.getGrade().name()).isEqualTo(member.getGrade().name());
    }
}