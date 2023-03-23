package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@BasicBootTest
@Transactional
@Rollback(true)
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists member (name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into member values(?, ?)", "Jack", 3);
        jdbcTemplate.update("insert into member values(?, ?)", "Jimmy", 1);

        Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
        Assertions.assertThat(count).isEqualTo(2);
    }
    @Test
    void insertAndQuery1() {
        jdbcTemplate.update("insert into member values(?, ?)", "peter", 3);
        jdbcTemplate.update("insert into member values(?, ?)", "david", 1);

        Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

}
