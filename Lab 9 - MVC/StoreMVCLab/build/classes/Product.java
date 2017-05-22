
import java.util.*;
import javafx.beans.property.*;

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
    private final LinkedList<ProductObserver> observers = new LinkedList<>();

    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty stock = new SimpleIntegerProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) 
    {
        this.name.set(name);
        this.stock.set(stock);
        this.price.set(price);
    }
    
    private void setStock(int value) 
    {
        this.stock.set(value);
    }
    
    public final int getStock() 
    {
        return this.stock.get();
    }   
    
    public IntegerProperty stockProperty() {return stock;}
    public DoubleProperty priceProperty() {return price;}
    public final StringProperty nameProperty() {return name;}

    public void sell(int n) 
    {
        stock.set(stock.get() - n);
        double money = n * price.get();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) 
    {
        stock.set(stock.get() + n);
    }

    public boolean has(int n) 
    {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) 
    {
        observers.add(observer);
    }
    
    public final String getName() 
    {
        return name.get();
    }
    
    public final double getPrice() 
    {
        return price.get();
    }

    @Override
    public String toString() 
    {
        return stock + " " + name + " at $" + price;
    }
}
