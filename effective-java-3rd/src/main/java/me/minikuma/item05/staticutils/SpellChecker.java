package me.minikuma.item05.staticutils;

import me.minikuma.item05.DefaultDictionary;
import me.minikuma.item05.Dictionary;

import java.util.List;

/*
* Static Utils
* */
public class SpellChecker {

    private static final Dictionary dictionary = new DefaultDictionary();

    private SpellChecker() {

    }

    public static boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public static List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
