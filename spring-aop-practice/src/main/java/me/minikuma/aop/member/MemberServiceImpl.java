package me.minikuma.aop.member;

import me.minikuma.aop.member.annotation.ClassAop;
import me.minikuma.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "OK";
    }

    public String internal(String param) {
        return "OK";
    }
}
