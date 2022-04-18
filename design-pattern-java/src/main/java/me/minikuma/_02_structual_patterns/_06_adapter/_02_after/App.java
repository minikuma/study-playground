package me.minikuma._02_structual_patterns._06_adapter._02_after;

import me.minikuma._02_structual_patterns._06_adapter._01_before.AccountService;
import me.minikuma._02_structual_patterns._06_adapter._01_before.security.LoginHandler;
import me.minikuma._02_structual_patterns._06_adapter._01_before.security.UserDetailService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailService userDetailService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailService);
        String login = loginHandler.login("username", "username");
        System.out.println("login info : " + login);
    }
}
