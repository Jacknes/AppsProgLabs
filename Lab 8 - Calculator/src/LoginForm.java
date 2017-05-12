
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 12545404
 */
public class LoginForm extends Application {

    private final static String USERNAME = "sam";
    private final static String PASSWORD = "mypassword";
    
    private Label userNameLbl;
    private TextField userNameTf;
    private Label passwordLbl;
    private PasswordField passwordTf;
    private Text loginSuccessLbl;
    private Button login;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        userNameLbl = new Label("Username:");
        userNameTf = new TextField();
        passwordLbl = new Label("Password:");
        passwordTf = new PasswordField();
        login = new Button("Login");
        loginSuccessLbl = new Text("");
        
        
        GridPane gBox = new GridPane();
        gBox.add(userNameLbl, 0, 0);
        gBox.add(userNameTf, 1, 0);
        gBox.add(passwordLbl, 0, 1);
        gBox.add(passwordTf, 1,1);
        gBox.add(login, 1, 2);
        gBox.add(loginSuccessLbl, 1, 3);

        login.setOnAction(event -> {
            if (getUsername().equals(USERNAME) && getPassword().equals(PASSWORD)) {
                loginSuccessLbl.setText("Password correct!");
            } else {
                loginSuccessLbl.setText("Password incorrect!");
            }
            
        });
        
        stage.setScene(new Scene(gBox));
        stage.setTitle("Login");
        stage.show();
        
    }
    
    
    private String getUsername()
    {
        return userNameTf.getText();
    }
    
    private String getPassword()
    {
        return passwordTf.getText();
    }

}
