package me.minikuma._02_structual_patterns._06_adapter._02_after;

import me.minikuma._02_structual_patterns._06_adapter._01_before.Account;
import me.minikuma._02_structual_patterns._06_adapter._01_before.AccountService;
import me.minikuma._02_structual_patterns._06_adapter._01_before.security.UserDetailService;
import me.minikuma._02_structual_patterns._06_adapter._01_before.security.UserDetails;

public class AccountUserDetailsService implements UserDetailService {

    AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account accountByUsername = accountService.findAccountByUsername(username);
        return new AccountUserDetails(accountByUsername);
    }
}
