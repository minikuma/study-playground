package me.minikuma.item05;

import java.util.ArrayList;
import java.util.List;

public class DefaultDictionary implements Dictionary {
    public static final List<String> stored = new ArrayList<>();

    // 사전 등록
    public void addDictionary(String word) {
        stored.add(word);
    }
    // 사전 조회
    public boolean contains(String word) {
        return stored.contains(word);
    }
    // 단어 제안
    public List<String> closeWordsTo(String typo) {
        return stored;
    }
}
