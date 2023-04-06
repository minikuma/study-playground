package me.minikuma.order;

public class Order {
    private Long id;
    private Long memberId;
    private String productName;
    private int productPrice;
    private int discountPrice;

    public Order(Long id, Long memberId, String productName, int productPrice, int discountPrice) {
        this.id = id;
        this.memberId = memberId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.discountPrice = discountPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int calculatorPrice() {
        return this.productPrice - this.discountPrice;
    }
}
