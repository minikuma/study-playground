package me.minikuma.item02.hierachical_builder;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.MUSHROOM)
                        .build();

        System.out.println("NY Pizza: " + nyPizza);
        System.out.println("Calzone Pizza: " + calzone);
    }
}
