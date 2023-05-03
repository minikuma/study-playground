package me.minikuma.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationNetworkClient {
    private String url;

    public AnnotationNetworkClient() {
        System.out.println("생성자 호출, URL = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect to url = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + message);
    }

    public void disconnect() {
        System.out.println("Closed");
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 메시지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
