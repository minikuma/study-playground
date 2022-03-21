package me.minikuma.singleton;

/**
 * Meta Data 를 Singleton 으로 만든다. (일반적 방법)
 * - 리플렉션에 의해 싱글톤이 성립되지 않게 만들 수 있음
 * - Multiple Thread 에 안전하지 않음
 */
public class MetaDataV1 {

    private static MetaDataV1 instance;

    private MetaDataV1() {}

    public static MetaDataV1 getInstance() {
        if (instance == null) {
            instance = new MetaDataV1();
        }
        return instance;
    }
}
