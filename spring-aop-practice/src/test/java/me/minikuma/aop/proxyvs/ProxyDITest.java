package me.minikuma.aop.proxyvs;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.member.MemberService;
import me.minikuma.aop.member.MemberServiceImpl;
import me.minikuma.aop.proxyvs.code.ProxyDIAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"})
@Import(ProxyDIAspect.class)
class ProxyDITest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    void go() {
        log.info("memberService class = {}", memberService.getClass());
        log.info("memberServiceImpl class = {}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
