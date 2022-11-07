package me.minikuma.item08.finalizer_attack;

import java.math.BigDecimal;

public class Account {
    private final String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        if (accountId.equals("hacker")) {
            throw new IllegalArgumentException("block!");
        }
    }

    public void transfer(BigDecimal amount, String to) {
        System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
    }

    @Override
    protected final void finalize() throws Throwable {

    }
}
