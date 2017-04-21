import java.text.*;

public class CashRegister {
    private double cash;

    public CashRegister() {
        this.cash = 0; //The cash register always starts with 0 money, no parameters are required for the parameter.
    }

    public void add (double money) {
        cash += money; //Adds the money parameter to the private cash variable in the class
    }

    @Override
    public String toString() { //Modified toString function
        if (cash == 0.0) //if there is no casg, return empty rather than 0.0
        {
            return "Cash register: empty";
        }
        return "Cash register: $" + formatted(cash); //if there is cash, return that.
    }

    private String formatted(double amount) { //Given formatted function.
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
