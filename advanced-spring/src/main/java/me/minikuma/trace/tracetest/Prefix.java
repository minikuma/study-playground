package me.minikuma.trace.tracetest;

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
