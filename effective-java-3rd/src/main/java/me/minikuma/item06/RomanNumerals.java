package me.minikuma.item06;

import java.util.regex.Pattern;

// 정규 표현식
public class RomanNumerals {
    // 캐싱 방법
    static boolean isRomanNumerals(String s) {
        return s.matches("^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$");
    }

    // 재사용 (미리 컴파일)
    private static final Pattern ROMAN = Pattern.compile("^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$");

    static boolean isRomanNumeralsFaster(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        boolean result = false;
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            result = isRomanNumeralsFaster("MCMLXXVI");
        }
        long end = System.nanoTime();
        System.out.println("경과 시간: " + (end - start));
    }
}
