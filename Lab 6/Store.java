
import java.util.*;

public class Store {

    private CashRegister cashRegister;
    private LinkedList<Product> products = new LinkedList<Product>();

    public static void main(String[] args) {
        new Store().use();
    }

    public Store() {
        products.add(new Product("Whiteboard Marker", 85, 1.50));
        products.add(new Product("Whiteboard Eraser", 45, 5.00));
        products.add(new Product("Black Pen", 100, 1.50));
        products.add(new Product("Red Pen", 100, 1.50));
        products.add(new Product("Blue Pen", 100, 1.50));
        cashRegister = new CashRegister();
    }

    private char readChoice() {
        System.out.print("Choice (s/r/v/c/p/x): ");
        return In.nextChar();
    }

    private void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 's':
                    sell();
                    break;
                case 'r':
                    restock();
                    break;
                case 'v':
                    viewStock();
                    break;
                case 'c':
                    viewCash();
                    break;
                case 'p':
                    pruneProducts();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void sell() {
        String name = readName();
        LinkedList<Product> productsFound = new LinkedList();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productsFound.add(product);
            }
        }

        if (productsFound.isEmpty()) {
            System.out.println("No such product");
        } else if (productsFound.size() == 1) {
            Product product = productsFound.get(0);
            System.out.println("Selling " + name);
            int number = readNumber();
            double profit = product.sell(number);
            cashRegister.add(profit);
        } else {
            System.out.println("Multiple products match:");
            for (Product product : productsFound) {
                System.out.println(product);
            }
        }

    }

    private void restock() {
        String name = readName();
        boolean restock = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                restock = true;
                System.out.println("Restocking " + product.getName());
                int number = readNumber();
                product.restock(number);
            } 
        }
        if (restock == false){
            System.out.println("Adding new product");
            int number = readNumber();
            double price = readPrice();
            Product product = new Product(name, number, price);
            products.add(product);
        }
    }

    private void viewStock() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void viewCash() {
        System.out.println(cashRegister);
    }

    private void pruneProducts() {
        LinkedList<Product> toBeRemoved = new LinkedList();
        for (Product product : products) {
            if (product.isEmpty()) {
                toBeRemoved.add(product);
            }
        }
        products.removeAll(toBeRemoved);
    }

    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    private double readPrice() {
        System.out.print("Price: $");
        return In.nextDouble();
    }

    private int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private boolean productExists(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }

}
