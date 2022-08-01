package me.minikuma.item05.dependencyinjection;

import me.minikuma.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

/**
 * 의존성 주입
 */
public class SpellChecker {
    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    // supplier
    public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
