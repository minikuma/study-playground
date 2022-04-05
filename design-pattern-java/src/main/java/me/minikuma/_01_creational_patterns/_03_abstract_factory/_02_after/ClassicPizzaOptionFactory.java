package me.minikuma._01_creational_patterns._03_abstract_factory._02_after;

import me.minikuma._01_creational_patterns._03_abstract_factory._01_before.Dough;
import me.minikuma._01_creational_patterns._03_abstract_factory._01_before.Sauce;

public class ClassicPizzaOptionFactory implements PizzaOptionFactory {
    @Override
    public Sauce selectSauce() {
        return new ClassicPizzaSauce();
    }

    @Override
    public Dough selectDough() {
        return new ClassicPizzaDough();
    }
}
