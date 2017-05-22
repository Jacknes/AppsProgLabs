
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacknes
 */
public class StoreController {
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    @FXML private Text productTxt;
    
    public Store store = new Store();
   
    @FXML private void initialize() 
    {
       setAmount(0);
       productTxt.textProperty().bind(store.getProduct().nameProperty());
       stockTxt.textProperty().bind(store.getProduct().stockProperty().asString().concat(" items"));
       priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
       cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
       
    }
    
    private int getAmount() 
    {
        return Integer.parseInt(amountTf.getText());
    }
    
    private void setAmount(int amount) 
    {
        amountTf.setText("" + amount);
    }
    
    public final Store getStore() 
    {
        return store;
    }
            
    @FXML private void handleSell(ActionEvent event)
    {
        if(store.getProduct().has(getAmount())) 
            store.getProduct().sell(getAmount());   
        setAmount(0);
    }  
}
