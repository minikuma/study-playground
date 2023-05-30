package me.minikuma.trace.callback;

import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.logtrace.LogTrace;

public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T res = callback.call();
            trace.end(status);
            return res;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
