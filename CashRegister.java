import java.text.*;

/**
 * The cash register stores cash.
 *
 * You can add cash to the cash register.
 */
public class CashRegister {
    private double cash;

    public CashRegister() {
        this.cash = 0;
    }

    public void add (double money) {
        cash += money;
    }

    /**
     * Return a string in the form:
     *
     * Cash register: $[cash]
     *
     * e.g. "Cash register: $29.90"
     *
     * If there is no cash, instead return:
     *
     * "Cash register: empty"
     */
    @Override
    public String toString() {
        if (cash == 0.0) {
            return "Cash register: empty";
        }
        return "Cash register: $" + formatted(cash);
    }
    
    private String formatted(double amount) {
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
