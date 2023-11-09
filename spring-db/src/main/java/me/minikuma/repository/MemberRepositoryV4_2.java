package me.minikuma.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * SQLErrorCodeSQLExceptionTranslator 사용
 */

@Slf4j
public class MemberRepositoryV4_2 implements MemberRepository {

    private final DataSource dataSource;
    private final SQLExceptionTranslator translator;

    public MemberRepositoryV4_2(DataSource dataSource) {
        this.dataSource = dataSource;
        this.translator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
    }

    @Override
    public Member save(Member member) {
        // SQL
        String sql = "insert into member(member_id, money) values (?, ?)";

        // connection
        Connection conn = null;

        // statement
        PreparedStatement pstm = null;

        // connection 획득
        try {
            conn = getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, member.getMemberId());
            pstm.setInt(2, member.getMoney());
            pstm.executeUpdate();

            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw Objects.requireNonNull(translator.translate("save", sql, e));
        } finally {
            close(conn, pstm, null);
        }
    }

    // 조회
    @Override
    public Member findById(String memberId) {
        String sql = "select * from member where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
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
            throw Objects.requireNonNull(translator.translate("findById", sql, e));
        } finally {
            close(conn, psmt, rs);
        }
    }

    @Override
    public void update(String memberId, int money) {
        String sql = "update member set money = ? where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, money);
            psmt.setString(2, memberId);
            int resultSize = psmt.executeUpdate(); // row 수 반환
            log.info("result size = {}", resultSize);
        } catch (SQLException e) {
            log.error("DB Update Error!");
            throw Objects.requireNonNull(translator.translate("update", sql, e));
        } finally {
            close(conn, psmt, null);
        }
    }

    // 조건으로 유입된 회원을 삭제
    @Override
    public void delete(String memberId) {
        String sql = "delete from member where member_id = ?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("delete error");
            throw Objects.requireNonNull(translator.translate("delete", sql, e));
        } finally {
            close(conn, psmt, null);
        }
    }

    // 테스트를 위한 전체 delete
    @Override
    public void deleteAll() {
        String sql = "delete from member";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("delete all Error!");
            throw Objects.requireNonNull(translator.translate("deleteAll", sql, e));
        } finally {
            close(conn, psmt, null);
        }
    }

    // 트랜젝션 동기화
    private Connection getConnection() throws SQLException {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        log.info("get Connection = {}, class = {}", conn, conn.getClass());
        return conn;
    }

    // 트랜젝션 정리
    private void close(Connection conn, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        // 트랜젝션 동기화를 사용 하려면 꼭 필요!
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
