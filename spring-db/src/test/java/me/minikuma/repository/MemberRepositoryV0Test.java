package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    @DisplayName("회원 등록 테스트 - 성공")
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10000);
        repository.save(member);

        Member findMember = repository.findById(member.getMemberId());
        log.info("find member = {}", findMember);
        log.info("member != findMember {}", member == findMember);
        log.info("member equals findMember = {}", member.equals(findMember));
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}