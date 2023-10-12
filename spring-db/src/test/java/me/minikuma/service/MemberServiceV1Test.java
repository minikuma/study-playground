package me.minikuma.service;

import me.minikuma.connection.ConnectionConst;
import me.minikuma.domain.Member;
import me.minikuma.repository.MemberRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceV1Test {
    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_EX = "ex";

    private MemberRepositoryV0 memberRepository;
    private MemberServiceV1 memberService;

    @BeforeEach
    void before() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(ConnectionConst.URL, ConnectionConst.USERNAME, ConnectionConst.PASSWORD);
        memberRepository = new MemberRepositoryV0(dataSource);
        memberService = new MemberServiceV1(memberRepository);
    }

    @AfterEach
    void after() throws SQLException {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("정상 동작 (이체 성공)")
    void transferOk() throws SQLException {
        // given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);

        memberRepository.save(memberA);
        memberRepository.save(memberB);

        // when
        memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);

        // then
        Member findMemberA = memberRepository.findById(memberA.getMemberId());
        Member findMemberB = memberRepository.findById(memberB.getMemberId());

        Assertions.assertThat(findMemberA.getMoney()).isEqualTo(8000);
        Assertions.assertThat(findMemberB.getMoney()).isEqualTo(12000);
    }

    @Test
    @DisplayName("계좌 이체 금액이 부족한 경우")
    void transferMoneyLack() throws SQLException {
        // given
        Member memberA = new Member(MEMBER_A, 0);
        Member memberB = new Member(MEMBER_B, 10000);

        memberRepository.save(memberA);
        memberRepository.save(memberB);

        // when + then
        Assertions.assertThatThrownBy(() -> memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 1000))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("계좌 이체 작업 중 하나만 성공한 경우")
    void transferNotBalance() throws SQLException {
        // given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberEx = new Member(MEMBER_EX, 10000);

        memberRepository.save(memberA);
        memberRepository.save(memberEx);

        // when
        Assertions.assertThatThrownBy(() -> memberService.accountTransfer(memberA.getMemberId(), memberEx.getMemberId(), 1000))
                .isInstanceOf(IllegalStateException.class);

        // then
        Member findMemberA = memberRepository.findById(memberA.getMemberId());
        Member findMemberEx = memberRepository.findById(memberEx.getMemberId());
        Assertions.assertThat(findMemberA.getMoney()).isEqualTo(9000);
        Assertions.assertThat(findMemberEx.getMoney()).isEqualTo(10000); // 그대로!
    }
}