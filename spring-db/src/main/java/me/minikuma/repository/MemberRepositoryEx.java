package me.minikuma.repository;

import me.minikuma.domain.Member;

import java.sql.SQLException;

/**
 * throws SQLException, JDBC 에 종속됨
 */
public interface MemberRepositoryEx {
    Member save(Member member) throws SQLException;
    Member findById(String memberId) throws SQLException;
    void update(String memberId, int money) throws SQLException;
    void delete(String memberId) throws SQLException;
}
