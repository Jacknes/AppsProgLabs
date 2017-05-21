
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacknes
 */
public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private String name;
    private int stock;
    private double price;

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    public final String getName() {return name;}
    public final String getPrice() {return "$"+price;}

    public void sell(int n) {
        stock = stock - n;
        double money = n * price;
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock = stock + n;
    }

    public boolean has(int n) {
        return stock >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }
    
    

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
