package me.minikuma._01_creational_patterns._03_abstract_factory._01_before;

public class Pizza {

    private String name;
    private Sauce sauce;
    private Dough dough;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }
}
