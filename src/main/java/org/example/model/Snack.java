package org.example.model;

public class Snack extends Product {

    private boolean vegan;


    public Snack(int id, double price, String snack) {
        super(id, price, snack);
        this.vegan = vegan;
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", snack: " + getProductName() + " }";
    }

    @Override
    public String use() {
        String description = "Enjoy now your: " + getProductName();
        description += vegan ? " 100% vegan" : "";
        return description;
    }

}
