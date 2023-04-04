package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@BasicBootTest
class HelloRepositoryTest {
    @Autowired HelloRepository helloRepository;
    // @Autowired JdbcTemplate jdbcTemplate;

    /* @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists members (name varchar(50) primary key, count int)");
    }*/

    @Test
    void findMembersFailed() {
        Assertions.assertThat(helloRepository.findMembers("minikuma")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("minikuma")).isEqualTo(0);

        helloRepository.increase("minikuma");
        Assertions.assertThat(helloRepository.countOf("minikuma")).isEqualTo(1);

        helloRepository.increase("minikuma");
        Assertions.assertThat(helloRepository.countOf("minikuma")).isEqualTo(2);
    }
}
