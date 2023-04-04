package me.minikuma.item06.expression;

import java.util.regex.Pattern;

public class RegularExpression {

    private static final Pattern SPLIT_PATTERN = Pattern.compile(";;;;");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            String name = "minikuma;;;;kuma";
            name.split(name);
        }
        System.out.println(System.nanoTime() - start);
    }
}
