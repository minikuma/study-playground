package me.minikuma.item08.finalizer_attack;

import java.math.BigDecimal;

public class BrokenAttack extends Account {
    public BrokenAttack(String accountId) {
        super(accountId);
    }

    // 재 정의 불가로 변경해줌
//    @Override
//    protected void finalize() throws Throwable {
//        this.transfer(BigDecimal.valueOf(100000), "good");
//    }
}
