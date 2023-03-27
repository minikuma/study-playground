package me.minikuma;

public class Members {
    private final String name;
    private final int count;

    public Members(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
