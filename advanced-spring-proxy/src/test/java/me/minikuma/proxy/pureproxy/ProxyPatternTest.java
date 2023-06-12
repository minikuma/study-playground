package me.minikuma.proxy.pureproxy;

import me.minikuma.proxy.pureproxy.code.CacheProxy;
import me.minikuma.proxy.pureproxy.code.ProxyPatternClient;
import me.minikuma.proxy.pureproxy.code.RealSubject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProxyPatternTest {

    @Test
    @DisplayName("프록시가 없는 경우")
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    @DisplayName("프록시가 존재하는 경우")
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();
    }
}
