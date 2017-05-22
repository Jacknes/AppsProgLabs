

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
public class CashRegister implements ProductObserver {
    private final DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.0);
    }

    public void add(double money) 
    {
        cash.set(cash.get() + money);
    }

    private void setCash(int value) 
    {
        this.cash.set(value);
    }
    
    public DoubleProperty cashProperty() 
    {
        return cash;
    }
    
    public final double getCash() 
    {
        return this.cash.get();
    } 
    
    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
