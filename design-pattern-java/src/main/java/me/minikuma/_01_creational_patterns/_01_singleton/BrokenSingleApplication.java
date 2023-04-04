package me.minikuma._01_creational_patterns._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 싱글톤을 깨뜨리는 방법
 *  1. 리플렉션
 *  2. 직렬화 역 직렬화
 */

public class BrokenSingleApplication {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MetaDataV5 metaDataV5 = MetaDataV5.getInstance();
        // use reflection
        Constructor<MetaDataV5> constructor = MetaDataV5.class.getDeclaredConstructor();
        constructor.setAccessible(true); // private 생성자 호출 가능
        MetaDataV5 check = constructor.newInstance();
        System.out.println("metaDataV5 == check :: " + (check == metaDataV5));
    }
}
