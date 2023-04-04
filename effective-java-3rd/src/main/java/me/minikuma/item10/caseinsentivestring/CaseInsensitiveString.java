package me.minikuma.item10.caseinsentivestring;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 코드 10-1) 대칭성 위배
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        }
        if (obj instanceof String) { // 한 방향 작동 다른 타입 지원(string 으로 간주)
            return s.equalsIgnoreCase((String) obj);
        }
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String polish = "polish";

        System.out.println(cis.equals(polish));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(polish));
    }
}
