package me.minikuma.item03;

public class Concert {
    private boolean lightOn;
    private boolean mainStateOpen;

    private Singer Singer;

    public Concert(Singer singer) {
        this.Singer = singer;
    }

    public void perform() {
        mainStateOpen = true;
        lightOn = true;
        Singer.sing();
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public boolean isMainStateOpen() {
        return mainStateOpen;
    }
}
