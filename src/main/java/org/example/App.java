package org.example;

import org.example.data.VendingMachine;
import org.example.data.VendingMachineManager;
import org.example.model.Beverage;
import org.example.model.Fruit;
import org.example.model.Product;
import org.example.model.Snack;


public class App 
{
    public static void main( String[] args ) {
        Product[] products = {
                new Beverage(1, "Pucko", true, 3, 45),
                new Beverage(2, "Milk", false, 1.5, 25),
                new Fruit(3, "Banana", false, 15),
                new Fruit(4, "Red apple", true, 24),
                new Snack(5, 20, "Sour creme Chips"),
                new Snack(6, 18, "Snickers")
        };
        VendingMachine vendingMachine = new VendingMachineManager(products);

        for (String string : vendingMachine.getProducts()) {
            System.out.println(string);
            System.out.println("-----");
        }

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(50);
        Product redApple = vendingMachine.request(4);
        System.out.println(redApple.use());
        System.out.println(vendingMachine.getBalance());

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(100);
        Product pucko = vendingMachine.request(1);
        System.out.println(pucko.use());
        System.out.println(vendingMachine.getBalance());

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(20);
        Product banana = vendingMachine.request(3);
        System.out.println(banana.use());
        System.out.println(vendingMachine.getBalance());

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(200);
        Product milk = vendingMachine.request(2);
        System.out.println(milk.use());
        System.out.println(vendingMachine.getBalance());

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(100);
        Product snickers = vendingMachine.request(6);
        System.out.println(snickers.use());
        System.out.println(vendingMachine.getBalance());

        System.out.println("---------------------------------------");

        vendingMachine.addCurrency(500);
        Product sourChips = vendingMachine.request(5);
        System.out.println(sourChips.use());
        System.out.println(vendingMachine.getBalance());

    }
}
