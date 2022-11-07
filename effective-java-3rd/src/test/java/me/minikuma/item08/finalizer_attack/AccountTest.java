package me.minikuma.item08.finalizer_attack;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void 일반_계정() {
        Account good = new Account("good");
        good.transfer(BigDecimal.valueOf(10.4), "man");
    }

    @Test
    void 해커_계정() {
        Account hacker = new Account("hacker");
        hacker.transfer(BigDecimal.valueOf(10.4), "man");
    }
}