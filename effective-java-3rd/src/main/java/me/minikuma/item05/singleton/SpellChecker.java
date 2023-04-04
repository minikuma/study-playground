package me.minikuma.item05.singleton;

import me.minikuma.item05.DefaultDictionary;
import me.minikuma.item05.Dictionary;

import java.util.List;

/*
 * 싱글톤
 * */
public class SpellChecker {

    private final Dictionary dictionary = new DefaultDictionary();

    private SpellChecker() {

    }

    // 싱글톤
    public static final SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
