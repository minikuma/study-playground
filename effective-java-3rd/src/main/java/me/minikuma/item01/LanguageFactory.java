package me.minikuma.item01;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ServiceLoader;

public class LanguageFactory {
    // 매개 변수에 따라 하위 타입을 리턴할 수 있다.
    public static Language of(String lang) {
        if (lang.equals("ko")) {
            return new Korean(); // 하위 타입 리턴 가능
        } else if (lang.equals("en")) {
            return new English();
        } else {
            throw new NoSuchElementException("지원하는 언어 없음");
        }
    }

    // client
    public static void main(String[] args) {
        Language language = LanguageFactory.of("ko");
        System.out.println(language.say());

        // 서비스 프로바이더 -> 인터페이스만 있어도 된다. (구현체 없이)
        ServiceLoader<Language> loader = ServiceLoader.load(Language.class);
        Optional<Language> findFirstLoader = loader.findFirst();
        findFirstLoader.ifPresent(lang -> System.out.println(lang.say()));
    }
}
