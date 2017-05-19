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
    private double cash;

    public CashRegister() {
        cash = 0.0;
    }

    public void add(double money) {
        cash = cash + money;
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
