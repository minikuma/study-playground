package me.minikuma.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator {
//    private final Component component;
//
//    public MessageDecorator(Component component) {
//        this.component = component;
//    }

    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = super.operation();
        String decoratorResult = "*****" + result + "*****";
        log.info("MessageDecorator 꾸미기 적용 전 = {}, 적용 후 = {}", result, decoratorResult);
        return decoratorResult;
    }
}
