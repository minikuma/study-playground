package me.minikuma.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minikuma.connection.ConnectionConst;
import me.minikuma.domain.Member;
import me.minikuma.repository.ex.MyDbException;
import me.minikuma.repository.ex.MyDuplicateKeyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import static me.minikuma.connection.ConnectionConst.*;

public class ExTranslatorV1Test {

    Repository repository;
    Service service;

    @BeforeEach
    void before() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        this.repository = new Repository(dataSource);
        this.service = new Service(repository);
    }

    @Test
    void duplicateKeySave() {
        service.create("myId");
        service.create("myId");
    }

    @Slf4j
    @RequiredArgsConstructor
    static class Service {
        private final Repository repository;

        public void create(String memberId) {
            try {
                repository.save(new Member(memberId, 1000));
                log.info("saveId = {}", memberId);
            } catch (MyDuplicateKeyException e) {
                log.error("키 중복, 복구 시도!");
                String retryId = generateNewId(memberId);
                log.info("retryId = {}", retryId);
                repository.save(new Member(retryId, 1000));
            } catch (MyDbException e) {
                log.error("DB 접근 예외");
            }
        }

        private String generateNewId(String memberId) {
            return memberId + new Random().nextInt(10000);
        }
    }

    @RequiredArgsConstructor
    static class Repository {
        private final DataSource dataSource;

        public Member save(Member member) {
            Connection con = null;
            PreparedStatement psmt = null;
            String sql = "insert into member(member_id, money) values (?, ?)";

            try {
                con = dataSource.getConnection();
                psmt = con.prepareStatement(sql);
                psmt.setString(1, member.getMemberId());
                psmt.setInt(2, member.getMoney());
                psmt.executeUpdate();
                return member;
            } catch (SQLException e) {
                // h2 DB 인 경우
                if (e.getErrorCode() == 23505) {
                    throw new MyDuplicateKeyException(e);
                } else {
                    throw new MyDbException(e);
                }

            } finally {
                JdbcUtils.closeStatement(psmt);
                JdbcUtils.closeConnection(con);
            }
        }
    }
}
