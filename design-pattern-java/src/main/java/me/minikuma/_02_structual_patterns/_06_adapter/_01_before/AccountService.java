package me.minikuma._02_structual_patterns._06_adapter._01_before;

public class AccountService {
    public Account findAccountByUsername(String username) {
        // TODO: 실제로는 username 으로 찾을 수 있는 Account 객체를 반환해 준다.
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    public void createNewAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }
}
