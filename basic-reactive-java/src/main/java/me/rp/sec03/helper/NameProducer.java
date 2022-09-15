package me.rp.sec03.helper;

import me.rp.courseutil.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

/**
 * Name 생산자
 */
public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    // producer
    public void produce() {
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " : " + name);
    }
}
