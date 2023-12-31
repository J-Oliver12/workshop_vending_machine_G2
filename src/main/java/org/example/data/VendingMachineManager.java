package org.example.data;

import org.example.model.Product;

public class VendingMachineManager implements VendingMachine {


    public static final int[] VALID_DENOMINATIONS = {1, 2, 5, 10, 20 ,50, 100, 200, 500, 1000};
    private final Product[] products;
    public int depositPool;

    public VendingMachineManager(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }


    @Override
    public void addCurrency(int amount) {
        for (int validDenomination : VALID_DENOMINATIONS) {
            if (validDenomination == amount) {
                depositPool += amount;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid currency denomination.");
    }

    @Override
    public int getBalance() {
        return  depositPool;
    }

    @Override
    public Product request(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                int productPrice = (int) product.getPrice();
                if (productPrice <= depositPool) {
                    depositPool -= productPrice;
                    endSession();
                    return product;
                } else {
                    throw new RuntimeException("Product " + product.getProductName() + " is to expensive");
                }
            }
        }
        throw new RuntimeException("Could not find the Product with id " + id);
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }


    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine().concat(" price: " + product.getPrice());
            }
        }
        throw new IllegalArgumentException("Could not find the product with id " + id);
    }


    @Override
    public String[] getProducts() {
        String[] productsAsString = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productsAsString[i] = products[i].examine().concat(" price: " + products[i].getPrice());
        }
        return productsAsString;
    }

    public int calculateChange(int amountPaid, int productPrice) {
        if (amountPaid >= productPrice) {
            return amountPaid - productPrice;
        } else {
            throw new RuntimeException("Insufficient payment for the product.");
        }
    }

    public void processTransaction(int productId) {
        Product product = request(productId);
        int change = calculateChange(depositPool, (int) product.getPrice());
        System.out.println(product.use());
        System.out.println("Change: " + change);
        System.out.println("Your current balance is: " + getBalance());
        endSession();
    }




}
