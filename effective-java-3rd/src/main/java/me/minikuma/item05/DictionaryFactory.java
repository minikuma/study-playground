package me.minikuma.item05;

/**
 * 팩토리
 */
public class DictionaryFactory {
    public DefaultDictionary get() {
        return new DefaultDictionary();
    }
}
