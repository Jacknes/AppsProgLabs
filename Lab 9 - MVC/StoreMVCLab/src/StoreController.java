
import javafx.fxml.FXML;
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
    private Store store = new Store();
    
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    public final Store getStore() { return store; }
    
    public void handleSell()
    {
//        Group group = getStadium().getGroup();
//        int amount = getAmount();
//        if (group.canSell(amount))
//            group.sell(amount);
//        setAmount(0);
    }
    
    
}
