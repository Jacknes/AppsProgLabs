/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacknes
 */
public class Store {
    private final CashRegister cashRegister;
    private final Product product;
    
    public Store() 
    {
        cashRegister = new CashRegister();
        product = new Product("Sticky tape", 200, 2.99);
        product.addProductObserver(cashRegister);
    }
    
    public final CashRegister getCashRegister() 
    {
        return cashRegister;
    }
    
    public final Product getProduct() 
    {
        return product;
    }
}
