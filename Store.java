/**
 * The store has and sells one product: Sticky tape.
 *
 * You can sell and restock a product, view stock and view cash.
 */
import java.util.*;

public class Store {
    public static void main(String[] args) 
    {
       new Store().use();
    }
    private Product product;
    private CashRegister cashRegister;
    public Store()
    {
        product = new Product("Sticky tape", 200, 2.99);
        cashRegister = new CashRegister();
    }
//    public Store()
//    {
//        
//    }

    
//    public Store()
//    {
//        
//    }

    public void use() 
    {
        char choice;
        while ((choice = readOption()) != 'x') 
        {
            switch (choice) {
            case 's': sell(); break;
            case 'r': restock(); break;
            case 'v': viewStock(); break;
            case 'c': viewCash(); break;
            default: help(); break;
            }
        }
    }

    private void sell() 
    {
        int numberOfItems = readNumber();
        double salePrice = product.sell(numberOfItems);
        if (salePrice != 0.0) 
        {
            cashRegister.add(salePrice);
        } else {
            System.out.println("Not enough stock");
        }
    }
    
    private char readOption (){
        System.out.print("Choice (s/r/v/c/x): ");
        return In.nextChar();
    }

    private void restock() {
        product.restock(readNumber());
    }
    private int readNumber () {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private void viewStock() {
        System.out.println(product);
    }

    private void viewCash() {
        System.out.println(cashRegister);
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
