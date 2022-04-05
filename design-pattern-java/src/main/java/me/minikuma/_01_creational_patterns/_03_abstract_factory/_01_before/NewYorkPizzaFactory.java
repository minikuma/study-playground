package me.minikuma._01_creational_patterns._03_abstract_factory._01_before;

import me.minikuma._01_creational_patterns._03_abstract_factory._02_after.PizzaOptionFactory;

public class NewYorkPizzaFactory extends DefaultPizzaFactory {

    @Override
    public Pizza makePizza() {
        Pizza pizza = new Pizza();
        pizza.setName("뉴욕 피자");
        pizza.setSauce(new NewYorkPizzaSauce()); // 구체적인 클래스에 의존적
        pizza.setDough(new NewYorkPizzaDough()); // 구체적인 클래스에 의존적
        return pizza;
    }
}
