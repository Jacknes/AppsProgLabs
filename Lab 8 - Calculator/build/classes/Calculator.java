
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class Calculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception 
    {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First Number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second Number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField();

        // 2. create the branch node
        GridPane gBox = new GridPane();
        gBox.add(firstNumberLbl, 0, 0);
        gBox.add(secondNumberLbl, 0, 1);
        gBox.add(operationLbl, 0, 2);
        gBox.add(resultLbl, 0, 3);
        gBox.add(firstNumberTf, 1, 0);
        gBox.add(secondNumberTf, 1, 1);
        HBox hBox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
        gBox.add(hBox, 1, 2);
        gBox.add(resultTf, 1, 3);
        
        
        VBox box = new VBox(10, firstNumberLbl, firstNumberTf, secondNumberLbl, secondNumberTf, operationLbl, addBtn, subBtn, mulBtn, divBtn, resultLbl, resultTf);
        //box.setAlignment(Pos.CENTER);

        // 3. set the scene, show the stage
       
        
        //Event Handlers
        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setResult(subNumbers(getFirstNumber(), getSecondNumber()));
            } 
        });
        
        mulBtn.setOnAction(event -> setResult(mulNumbers(getFirstNumber(), getSecondNumber())));
        divBtn.setOnAction(event -> setResult(divNumbers(getFirstNumber(), getSecondNumber())));
        
        stage.setScene(new Scene(gBox));
        stage.setTitle("Calculator");
        stage.show();
    }
    
    private int getFirstNumber() 
    {
        return Integer.parseInt(firstNumberTf.getText());
    }
    
    private int getSecondNumber() 
    {
        return Integer.parseInt(secondNumberTf.getText());
    }
    
    
    private void setResult(int result) 
    {
        resultTf.setText("" + result);
    }
    
    
    private class AddHandler implements EventHandler<ActionEvent> 
    {
        @Override
        public void handle(ActionEvent t) 
        {
            setResult(addNumbers(getFirstNumber(), getSecondNumber()));
        }
        
             
    }
 
    private int addNumbers(int number1, int number2)
    {
            return number1 + number2;
    } 
    
    private int subNumbers (int number1, int number2) 
    {
        return number1 - number2;
    }
    
    private int mulNumbers (int number1, int number2) 
    {
        return number1 * number2;
    }
    
    private int divNumbers (int number1, int number2) 
    {
        return number1 / number2;
    }
    

}
