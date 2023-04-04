package me.minikuma._02_structual_patterns._08_composite._02_after;

public class App {
    public static void main(String[] args) {
        Product p1 = new Product("네파 경량 패팅 - 남자", 150000);
        Product p2 = new Product("네파 롱 패팅 - 여성", 200000);

        Bag bag = new Bag();
        bag.add(p1);
        bag.add(p2);

        App app = new App();
        app.printPrice(p1);
        app.printPrice(bag);
    }

    private void printPrice(Component component) { // 가장 추상적인 타입으로 사용
        System.out.println(component.getPrice());
    }
}
