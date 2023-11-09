package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

/**
 * JdbcTemplate
 */

@Slf4j
public class MemberRepositoryV5 implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryV5(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        // SQL
        String sql = "insert into member(member_id, money) values (?, ?)";
        jdbcTemplate.update(sql, member.getMemberId(), member.getMoney());
        return member;
    }

    // 조회
    @Override
    public Member findById(String memberId) {
        String sql = "select * from member where member_id = ?";
        return jdbcTemplate.queryForObject(sql, memberRowMapper(), memberId);
    }

    private RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> {
            Member member = new Member();
            member.setMemberId(rs.getString("member_id"));
            member.setMoney(rs.getInt("money"));
            return member;
        });
    }

    @Override
    public void update(String memberId, int money) {
        String sql = "update member set money = ? where member_id = ?";
        jdbcTemplate.update(sql, money, memberId);
    }

    // 조건으로 유입된 회원을 삭제
    @Override
    public void delete(String memberId) {
        String sql = "delete from member where member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }

    // 테스트를 위한 전체 delete
    @Override
    public void deleteAll() {
        String sql = "delete from member";
        jdbcTemplate.update(sql);
    }
}
