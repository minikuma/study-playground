package me.minikuma.connection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DBConnectionUtilsTest {
    @Test
    @DisplayName("H2 Driver Connection 을 가져 온다")
    void connection_ok() {
        Connection connection = DBConnectionUtils.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }
}
