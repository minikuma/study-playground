package me.minikuma.item03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * reflection 을 통해 싱글톤 성립되지 않게 하기
 */
public class ElvisReflection {
    public static void main(String[] args) {
        try {
            Constructor<Elvis> constructor = Elvis.class.getDeclaredConstructor();
            constructor.setAccessible(true); // private 생성자 호출 지원
            Elvis e1 = constructor.newInstance();
            Elvis e2 = constructor.newInstance();
            System.out.println(((e1 == e2) ? "동일 객체" : "다른 객체"));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
