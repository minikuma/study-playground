package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.connection.DBConnectionUtils;
import me.minikuma.domain.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * JDBC Driver Manager
 */

@Slf4j
public class MemberRepositoryV0 {

    private final DataSource dataSource;

    public MemberRepositoryV0(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    // 조회
    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnectionUtils.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);
            rs = psmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found member id = " + memberId);
            }

        } catch (SQLException e) {
            log.error("db 조회 에러", e);
            throw e;
        } finally {
            close(conn, psmt, rs);
        }
    }

    // 수정
    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money = ? where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DBConnectionUtils.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, money);
            psmt.setString(2, memberId);
            int resultSize = psmt.executeUpdate(); // row 수 반환
            log.info("result size = {}", resultSize);
        } catch (SQLException e) {
            log.error("DB Update Error!");
            throw e;
        } finally {
            close(conn, psmt, null);
        }
    }

    // 조건으로 유입된 회원을 삭제
    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DBConnectionUtils.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("delete error");
            throw e;
        } finally {
            close(conn, psmt, null);
        }
    }

    // 테스트를 위한 전체 delete
    public void deleteAll() throws SQLException {
        String sql = "delete from member";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DBConnectionUtils.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("delete all Error!");
            throw e;
        } finally {
            close(conn, psmt, null);
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
