package me.minikuma.trace;

import java.util.UUID;

public class TraceId {
    private final String id;
    private final int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPrevId() {
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isFirstLevel() {
        return this.level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }


    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
