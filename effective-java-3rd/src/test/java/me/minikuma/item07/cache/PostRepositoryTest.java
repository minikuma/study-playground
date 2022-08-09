package me.minikuma.item07.cache;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        CacheKey key = new CacheKey(1);
        postRepository.getPostById(key);

        assertFalse(postRepository.getCache().isEmpty());

        key = null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        assertTrue(postRepository.getCache().isEmpty());
    }

    @Test
    void backgroundThread() throws InterruptedException {
        ScheduledExecutorService execute = Executors.newScheduledThreadPool(1);
        PostRepository postRepository = new PostRepository();
        CacheKey cacheKey = new CacheKey(1);
        postRepository.getPostById(cacheKey);

        Runnable removeOldCache = () -> {
            System.out.println("running remove LRU Cache Task");
            Map<CacheKey, Post> cache = postRepository.getCache();
            Set<CacheKey> cacheKeys = cache.keySet();
            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
            key.ifPresent((k) -> {
                System.out.println("removing " + k);
                cache.remove(k);
            });
        };

        System.out.println("The time is : " + new Date());

        execute.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(20000L);
        execute.shutdown();
    }
}