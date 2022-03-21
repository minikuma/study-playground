package me.minikuma.singleton;

/**
 * 이른 초기화 (eager initialization)
 */
public class MetaDataV3 {

    private static final MetaDataV3 INSTANCE = new MetaDataV3();

    private MetaDataV3() {}

    public static MetaDataV3 getInstance() {
        return INSTANCE;
    }
}
