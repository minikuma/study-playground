package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.connection.DBConnectionUtils;
import me.minikuma.domain.Member;

import java.sql.*;

/**
 * JDBC Driver Manager
 */

@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member) throws SQLException {
        // SQL
        String sql = "insert into member(member_id, money) values (?, ?)";

        // connection
        Connection conn = null;

        // statement
        PreparedStatement pstm = null;

        // connection 획득
        try {
            conn = DBConnectionUtils.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, member.getMemberId());
            pstm.setInt(2, member.getMoney());
            pstm.executeUpdate();

            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(conn, pstm, null);
        }
    }

    private void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("Result Set Error!", e);
            }
        }

        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                log.error("statement error!", e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("db closed error!", e);
            }
        }
    }
}
