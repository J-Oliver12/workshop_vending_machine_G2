package org.example.model;



public abstract class Product {

    private final int id;
    private final double price;
    private final String productName;


    public Product(int id, double price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;
    }


    public abstract String examine();                          // Abstract method to examine the product.
                                                                // @return A description of the product examination.

    public abstract String use();                               //Abstract method to use the method.
                                                                //@return A description of using the product.



    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }


    public String getProductName() {
        return productName;
    }


}
