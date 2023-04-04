package me.minikuma._01_creational_patterns._01_singleton;
/**
    static inner 클래스 (추천 방법)
 */
public class MetaDataV5 {

    private MetaDataV5() {}

    // inner class
    private static class MetaDataHolder {
        private static final MetaDataV5 INSTANCE = new MetaDataV5();
    }

    public static MetaDataV5 getInstance() {
        return MetaDataHolder.INSTANCE;
    }
}
