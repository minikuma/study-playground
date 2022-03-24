package me.minikuma._01_creational_patterns._02_factory._01_step1;

public class Coffee {

    private String coffeeBean;
    private String type;

    public String getCoffeeBean() {
        return coffeeBean;
    }

    public void setCoffeeBean(String coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeBean='" + coffeeBean + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
