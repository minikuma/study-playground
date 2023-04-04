package me.minikuma._02_structual_patterns._11_flyweight._02_after;

/**
    Immutable Class (flyweight class)
 */
public final class Font {
    final String family;
    final int size;

    public Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public String getFamily() {
        return family;
    }

    public int getSize() {
        return size;
    }
}
