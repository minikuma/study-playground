package me.minikuma.exception.translator;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static me.minikuma.connection.ConnectionConst.*;

@Slf4j
class SpringExceptionTranslatorTest {
    DataSource dataSource;

    @BeforeEach
    void before() {
        this.dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }

    @Test
    @DisplayName("사용자가 직접 예외를 처리하는 경우")
    void sqlExceptionErrorCode() {
        String sql = "select bad grammar";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.executeUpdate();
        } catch (SQLException e) {
            Assertions.assertThat(e.getErrorCode()).isEqualTo(42122); // 너무 알아야 되는게 많다.
            int errorCode = e.getErrorCode();
            log.error("errorCode = {}", errorCode);
        }
    }

    @Test
    @DisplayName("스프링에서 제공하는 예외 추상화를 사용하는 경우")
    void springExceptionTranslator() {
        String sql = "select bad grammar";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.executeUpdate();
        } catch (SQLException e) {
            Assertions.assertThat(e.getErrorCode()).isEqualTo(42122);
            SQLErrorCodeSQLExceptionTranslator exTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
            DataAccessException resultEx = exTranslator.translate("select", sql, e);
            log.info("resultEx", resultEx);
            Assertions.assertThat(Objects.requireNonNull(resultEx).getClass()).isEqualTo(BadSqlGrammarException.class);
        }
    }
}
