package me.minikuma.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternClient extends Decorator {
    public DecoratorPatternClient(Component component) {
        super(component);
    }

//    private final Component component;
//
//    public DecoratorPatternClient(Component component) {
//        this.component = component;
//    }

    public void execute() {
        String result = super.operation();
        log.info("result={}", result);
    }
}
