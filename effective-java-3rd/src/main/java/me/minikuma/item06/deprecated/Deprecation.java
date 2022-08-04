package me.minikuma.item06.deprecated;

public class Deprecation {
    /**
     * @deprecated in favor of
     * {@link #Deprecation(String)}
     */
    @Deprecated(forRemoval = true, since = "1.2")
    public Deprecation() {

    }

    private String name;

    public Deprecation(String name) {
        this.name = name;
    }
}
