package org.example.model;

public class Beverage extends Product {
    private final boolean lactoseFree;
    private final double fatContent;

    public  Beverage(int id, String productName, boolean lactoseFree, double fatContent, double price){
        super(id, price, productName);
        this.lactoseFree = lactoseFree;
        this.fatContent = fatContent;
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", beverage: " + getProductName() + " with " + fatContent + " % fat" + ", price: " + getPrice() + "}";
    }

    @Override
    public String use() {
        String description = "Quench your thirst with a refreshing " + getProductName();
        description += lactoseFree ? " 100% lactose free" : "";
        return description;
    }
}
