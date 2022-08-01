package me.minikuma.item05.dependencyinjection;

import me.minikuma.item05.DefaultDictionary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid_1() {
        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
        assertTrue(spellChecker.isValid("test"));
    }

    @Test
    void isValid_supplier() {
        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
        assertTrue(spellChecker.isValid("test"));
    }
}