package org.example.model;

public class Fruit extends Product {

    private final boolean organic;

    public Fruit(int id, String fruitType, boolean organic, double price) {
        super(id, price, fruitType);
        this.organic = organic;
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", fruit: " + getProductName() + ", price: " + getPrice() + " }";
    }


    @Override
    public String use() {
        String description = getProductName() + " tastes delicious!";
        description += organic ? " and its 100% organic" : "";
        return description;
    }
}