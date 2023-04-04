package me.minikuma;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Members findMembers(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from members where name = '" + name + "'",
                    (rs, rowNum) -> new Members(rs.getString("name"), rs.getInt("count"))
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increase(String name) {
        Members members = findMembers(name);
        if (members == null) jdbcTemplate.update("insert into members values (?, ?)", name, 1);
        else jdbcTemplate.update("update members set count = ? where name = ?", members.getCount() + 1, name);
    }
}
