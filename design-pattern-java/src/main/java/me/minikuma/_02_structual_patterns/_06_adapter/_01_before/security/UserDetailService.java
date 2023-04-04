package me.minikuma._02_structual_patterns._06_adapter._01_before.security;

public interface UserDetailService {
    UserDetails loadUser(String username);
}
