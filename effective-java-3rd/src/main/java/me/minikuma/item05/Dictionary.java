package me.minikuma.item05;

import java.util.ArrayList;
import java.util.List;

public interface Dictionary {
    void addDictionary(String word);
    boolean contains(String word);
    List<String> closeWordsTo(String typo);
}
