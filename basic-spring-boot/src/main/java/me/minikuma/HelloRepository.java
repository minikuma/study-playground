package me.minikuma;


public interface HelloRepository {
    Members findMembers(String name);
    void increase(String name);

    default int countOf(String name) {
        Members members = findMembers(name);
        return members == null ? 0 : members.getCount();
    }
}
