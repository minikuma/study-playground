package me.minikuma._01_creational_patterns._01_singleton;

/**
 * Double-Checked Locking
 */
public class MetaDataV4 {

    private static volatile MetaDataV4 instance;

    private MetaDataV4() {}

    public static MetaDataV4 getInstance() {
        if (instance == null) {
            synchronized (MetaDataV4.class) {
                if (instance == null) {
                    instance = new MetaDataV4();
                }
            }
        }
        return instance;
    }
}
