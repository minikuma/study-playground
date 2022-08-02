package me.minikuma.item05.springioc;

import me.minikuma.item05.Dictionary;

import java.util.Collections;
import java.util.List;

public class SpringDictionary implements Dictionary {
    @Override
    public void addDictionary(String word) {
        System.out.println("word 등록");
    }

    @Override
    public boolean contains(String word) {
        System.out.println("Contains : " + word);
        return true;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        System.out.println("closed word : " + typo);
        return Collections.singletonList(typo);
    }
}
