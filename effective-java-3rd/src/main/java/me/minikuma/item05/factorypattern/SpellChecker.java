package me.minikuma.item05.factorypattern;

import me.minikuma.item05.Dictionary;

public class SpellChecker {
    private final Dictionary dictionary;

    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
    }
}
