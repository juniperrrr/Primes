
package project;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamePlay extends Application {
    Game game = new Game();
    
    int index = 0;
    int lives = 3;
    int quotient;
    boolean isComposite = true;
    boolean isNotDivisible = true;
    boolean quotientIsComposite = true;
    boolean isGameOver = true;
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList <Integer> compNumbers = new ArrayList<>(); 
        
        for(int i = 3; i <= 99; i++){ 
            for(int j = 2; j <= i/2; j++){
                if(i%j == 0){
                    compNumbers.add(i);
                    break; 
                }
            }
        }
        Collections.shuffle(compNumbers);
        
        Label number = new Label(compNumbers.get(index).toString());
        
        Label livesLbl = new Label(Integer.toString(lives));
        
        TextField input = new TextField();
        
        Button enterBtn = new Button("Enter");
        
        Alert alert = new Alert(AlertType.INFORMATION, "Game Over!");
        
        while(isGameOver){
            enterBtn.setOnAction(new EventHandler<ActionEvent>() {
            
                @Override
                public void handle(ActionEvent event) {
                    while(quotientIsComposite){
                        while(isComposite || isNotDivisible) {
                            isComposite = game.isInputPrimeNum(Integer.parseInt(input.getText()));
                            isNotDivisible = game.isDivisibleNum(Integer.parseInt(number.getText()), Integer.parseInt(input.getText()));
                                if(isComposite || isNotDivisible){
                                    lives--;
                                    livesLbl.setText(Integer.toString(lives));
                                }
                            }
                        quotient = Integer.parseInt(number.getText()) / Integer.parseInt(input.getText());
                        quotientIsComposite = game.isInputPrimeNum(quotient);
       
                        if(quotientIsComposite) {
                            number.setText(Integer.toString(quotient));
                            isComposite = true;
                            isNotDivisible = true;
                        }
                        else{
                            game.scoreCounter++;
                        }
                    }
                    if(lives == 0){
                        
                        alert.setContentText("Your score is" + game.scoreCounter);
                        alert.showAndWait();
                        isGameOver = false;
                    }
                }
            });
        }
        
        VBox vbox = new VBox(livesLbl, number, input, enterBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        
        GridPane root = new GridPane();
        root.getChildren().addAll(vbox);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 375, 600);
        
        primaryStage.setTitle("Game Of Primes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
