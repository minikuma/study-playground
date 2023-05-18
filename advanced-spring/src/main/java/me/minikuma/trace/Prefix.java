package me.minikuma.trace;

public enum Prefix {
    START_PREFIX("-->"),
    COMPLETE_PREFIX("<--"),
    EXCEPTION_PREFIX("<X-");

    private String value;

    Prefix(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
