package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static me.minikuma.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemberRepositoryV0Test {

    private MemberRepositoryV0 repository;

    @BeforeEach
    public void before() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        repository = new MemberRepositoryV0(dataSource);
        repository.deleteAll();
    }

    @Test
    @DisplayName("회원 테스트 - 성공")
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10000);
        // 저장
        repository.save(member);

        // member id 기준 으로 조회
        Member findMember = repository.findById(member.getMemberId());
        log.info("find member = {}", findMember);
        log.info("member != findMember {}", member == findMember);
        log.info("member equals findMember = {}", member.equals(findMember));
        assertThat(findMember).isEqualTo(member);

        // update : money 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        log.info("update money = {}", updatedMember.getMoney());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        // delete
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}