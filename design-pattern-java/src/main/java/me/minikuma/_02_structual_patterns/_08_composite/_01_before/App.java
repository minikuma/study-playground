package me.minikuma._02_structual_patterns._08_composite._01_before;

public class App {
    public static void main(String[] args) {

        Product p1 = new Product("네파-여성롱패딩", 150000);
        Product p2 = new Product("노스페이스-구스다운(남성)", 300000);

        Bag bag = new Bag();
        bag.add(p1);
        bag.add(p2);

        App app = new App();
        app.printPrice(p1);
        app.printPrice(bag);

    }

    private void printPrice(Bag bag) {
        int sum = bag.getProducts().stream().mapToInt(Product::getPrice).sum();
        System.out.println("장바구니 총 합계: " + sum);
    }

    private void printPrice(Product product) {
        System.out.println(product.getName() + " 의 가격은 " + product.getPrice());
    }
}
