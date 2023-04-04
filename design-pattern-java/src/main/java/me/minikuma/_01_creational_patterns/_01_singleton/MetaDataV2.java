package me.minikuma._01_creational_patterns._01_singleton;

/**
 * Thread-Safe 한 방법 (synchronized)
 */
public class MetaDataV2 {

    private static MetaDataV2 instance;

    private MetaDataV2() {}

    public static synchronized MetaDataV2 getInstance() {
        if (instance == null) {
            instance = new MetaDataV2();
        }
        return instance;
    }
}
