package me.minikuma.item05.factorypattern;

import me.minikuma.item05.DefaultDictionary;
import me.minikuma.item05.Dictionary;

public class DefaultDictionaryFactory implements DictionaryFactory {
    @Override
    public Dictionary getDictionary() {
        return new DefaultDictionary();
    }
}
