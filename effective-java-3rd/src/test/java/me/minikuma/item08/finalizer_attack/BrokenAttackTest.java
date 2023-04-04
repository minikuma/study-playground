package me.minikuma.item08.finalizer_attack;

import org.junit.jupiter.api.Test;

class BrokenAttackTest {

    @Test
    void broken_account() throws InterruptedException {
        Account account = null;
        try {
            account = new BrokenAttack("hacker");
        } catch (Exception e) {
            System.out.println("에러를 잡은 상태에서 계속 작업 중!!");
        }
        System.gc();
        Thread.sleep(3000L);
    }
}