package me.minikuma.lifecycle;

public class AdvancedNetworkClient {
    private String url;

    // 생성자
    public AdvancedNetworkClient() {
        System.out.println("생성자 호출, URL = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 연결
    public void connect() {
        System.out.println("connect: " + url);
    }

    // 종료
    public void disconnect() {
        System.out.println("closed: " + url);
    }

    // 메세지 전송
    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);
    }

    public void init() {
        connect();
        call("초기 연결 성공 >>> ");
    }

    public void close() {
        disconnect();
        System.out.println("연결 해제 >>> ");
    }

}