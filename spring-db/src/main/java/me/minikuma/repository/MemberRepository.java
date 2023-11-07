package me.minikuma.repository;

import me.minikuma.domain.Member;

/**
 * 특정 기술에 종속적이지 않은 인터페이스
 */
public interface MemberRepository {
    Member save(Member member);
    Member findById(String memberId);
    void update(String memberId, int money);
    void delete(String memberId);
    void deleteAll();
}
