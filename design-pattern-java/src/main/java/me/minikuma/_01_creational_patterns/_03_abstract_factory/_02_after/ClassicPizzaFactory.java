package me.minikuma._01_creational_patterns._03_abstract_factory._02_after;

import me.minikuma._01_creational_patterns._03_abstract_factory._01_before.DefaultPizzaFactory;
import me.minikuma._01_creational_patterns._03_abstract_factory._01_before.Pizza;

public class ClassicPizzaFactory extends DefaultPizzaFactory {

    private final ClassicPizzaOptionFactory classicPizzaOptionFactory;

    public ClassicPizzaFactory(ClassicPizzaOptionFactory classicPizzaOptionFactory) {
        this.classicPizzaOptionFactory = classicPizzaOptionFactory;
    }

    @Override
    public Pizza makePizza() {
        Pizza pizza = new Pizza();
        pizza.setName("클래식 피자");
        pizza.setSauce(classicPizzaOptionFactory.selectSauce());
        pizza.setDough(classicPizzaOptionFactory.selectDough());
        return pizza;
    }
}
