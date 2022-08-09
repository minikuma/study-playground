package me.minikuma.item07.cache;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {
    private Map<CacheKey, Post> cache;

    public PostRepository() {
        this.cache = new HashMap<>();
    }

    public Post getPostById(CacheKey key) {
        // key 생성
//        CacheKey cacheKey = new CacheKey(id);
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // 영속적인 저장소에서 읽어 올 수 있음
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
