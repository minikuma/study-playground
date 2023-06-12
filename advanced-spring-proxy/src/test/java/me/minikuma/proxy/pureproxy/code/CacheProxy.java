package me.minikuma.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {
    private final Subject targetSubject;
    private String cacheValue;

    public CacheProxy(Subject targetSubject) {
        this.targetSubject = targetSubject;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = targetSubject.operation();
        }
        return cacheValue;
    }
}
