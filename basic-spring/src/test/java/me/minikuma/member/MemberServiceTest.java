package me.minikuma.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    @Test
    @DisplayName("회원을 가입한다.")
    void member_join() {
        // given
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MeberServiceImpl(memberRepository);
        Member member = new Member(1L, "memberA", Grade.VIP);

        // 회원 가입
        memberService.join(member);

        // 가입된 회원 찾기
        Member savedMember = memberService.findMember(member.getId());

        // then
        Assertions.assertThat(savedMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(savedMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(savedMember.getGrade().name()).isEqualTo(member.getGrade().name());
    }
}