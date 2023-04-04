package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

@BasicBootTest
@Rollback(true)
class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists members (name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into members values(?, ?)", "Jack", 3);
        jdbcTemplate.update("insert into members values(?, ?)", "Jimmy", 1);

        Integer count = jdbcTemplate.queryForObject("select count(*) from members", Integer.class);
        Assertions.assertThat(count).isEqualTo(2);
    }
    @Test
    void insertAndQuery1() {
        jdbcTemplate.update("insert into members values(?, ?)", "peter", 3);
        jdbcTemplate.update("insert into members values(?, ?)", "david", 1);

        Integer count = jdbcTemplate.queryForObject("select count(*) from members", Integer.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

}
