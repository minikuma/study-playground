package me.minikuma.aop.proxyvs;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.MemberService;
import me.minikuma.aop.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class ProxyCastingTest {

    @Test
    @DisplayName("jdk proxy 테스트")
    void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); // JDK 동적 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();
        assertThat(memberServiceProxy).isNotNull();

        // JDK 동적 프록시를 구현 클래스로 캐스팅 시도 실패 예외 발생
        assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
        });
    }

    @Test
    @DisplayName("CGLIB Proxy 테스트")
    void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();
        assertThat(memberServiceProxy).isNotNull();

        log.info("proxy target = {}", memberServiceProxy.getClass());

        // CGLIB 프록시는 구현 클래스로 캐스팅 가능
        MemberServiceImpl castingMemberServiceImpl = (MemberServiceImpl) memberServiceProxy;
        assertThat(castingMemberServiceImpl).isNotNull();

        MemberService castingMemberService = memberServiceProxy;
        assertThat(castingMemberService).isNotNull();
    }
}
