package me.minikuma._01_item01;

public class Settings {
    private boolean useAutoSteering;
    private boolean useAbs;
    private Difficulty difficulty;

    private Settings() {

    }

    private static final Settings SETTINGS = new Settings();

    public static Settings newInstance() {
        return SETTINGS;
    }
}
