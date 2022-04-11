package me.minikuma._01_creational_patterns._04_builder._01_before;

public class Options {
    private String monitor;
    private String keyBoard;
    private String mouse;

    public Options(String monitor, String keyBoard, String mouse) {
        this.monitor = monitor;
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }
}
