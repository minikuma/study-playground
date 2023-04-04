package me.minikuma.item07.cache;

import java.time.LocalDateTime;

public class CacheKey {
    private Integer value;
    private LocalDateTime created;

    public CacheKey(Integer val) {
        this.value = val;
        this.created = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(obj);
    }

    @Override
    public String toString() {
        return "CacheKey{" +
                "value=" + value +
                ", created=" + created +
                '}';
    }
}
