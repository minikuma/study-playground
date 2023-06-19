package me.minikuma.proxy.concretproxy;


import me.minikuma.proxy.concretproxy.code.ConcreteClient;
import me.minikuma.proxy.concretproxy.code.ConcreteLogic;
import me.minikuma.proxy.concretproxy.code.TimeProxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConcreteProxyTest {
    @Test
    @DisplayName("프록시 도입 전 테스트")
    void noProxy() {
        ConcreteClient client = new ConcreteClient(new ConcreteLogic());
        client.execute();
    }

    @Test
    @DisplayName("프록시 적용")
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
