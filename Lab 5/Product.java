import java.text.*;

public class Product {
    private String name;
    private int stock;
    private double price;
    public Product(String name, int stock, double price)  //initilises the a product with the name, stock and price.
    {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public double sell(int n) {
        if (stock >= n) { //Checks there is enough stock for the amount they user wants to sell.
            stock -= n; //if there is, perform the sale and return the price of all items. n * price. (number of items * price)
            return price * n;
        }

        return 0.0; // if there is not enough stock, return 0 money made.
    }

    public void restock(int n) {
        stock += n; //adds stock.
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
