
package project;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Start extends Application {
    GamePlay gp = new GamePlay();
    
    Group root = new Group();
    Group root1 = new Group();
    
    Scene scene = new Scene(root, 375, 600);
    Scene scene1 = new Scene(root1, 375, 600);
    
    VBox vbox = new VBox();
    
    Image screen = new Image(getClass().getResource("Images/start_screen.gif").toString());
    ImageView start_screen = new ImageView(screen);
    
    Image start = new Image(getClass().getResource("Images/start.jpg").toString());
    ImageView startBtn = new ImageView(start);
    
    Image howTo = new Image(getClass().getResource("Images/how-to.jpg").toString());
    ImageView howToBtn = new ImageView(howTo);
    
    Image exit = new Image(getClass().getResource("Images/exit.jpg").toString());
    ImageView exitBtn = new ImageView(exit);
    
    Image how = new Image(getClass().getResource("Images/how_to.jpg").toString());
    ImageView how_to = new ImageView(how);
    
    Image back = new Image(getClass().getResource("Images/back.jpg").toString());
    ImageView backBtn = new ImageView(back);
    
    @Override
    public void start(Stage primaryStage) {
        start_screen.fitHeightProperty().bind(primaryStage.heightProperty());
        start_screen.fitWidthProperty().bind(primaryStage.widthProperty());
        start_screen.setPreserveRatio(true);
        
        vbox.getChildren().addAll(startBtn, howToBtn, exitBtn);
        vbox.setLayoutX(100);
        vbox.setLayoutY(400);
        vbox.setSpacing(5);
        
        root.getChildren().addAll(start_screen, vbox);
        
        this.StartButton(primaryStage);
        this.HowToButton(primaryStage);
        this.ExitButton(primaryStage);
        
        primaryStage.setTitle("Game Of Primes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void StartButton(Stage primaryStage){
        startBtn.setOnMousePressed((MouseEvent me) -> {
            gp.start(primaryStage);
        });
    }
    
    public void HowToButton(Stage primaryStage){
        howToBtn.setOnMousePressed((MouseEvent me) -> {
            primaryStage.setScene(scene1);
            
            how_to.fitHeightProperty().bind(primaryStage.heightProperty());
            how_to.fitWidthProperty().bind(primaryStage.widthProperty());
            how_to.setPreserveRatio(true);
            
            backBtn.setLayoutX(100);
            backBtn.setLayoutY(500);
            backBtn.setOnMousePressed((MouseEvent me_1) -> {
                primaryStage.setScene(scene);
            });
            
            root1.getChildren().addAll(how_to, backBtn);
        });
    }
    
    public void ExitButton(Stage primaryStage){
        exitBtn.setOnMousePressed((MouseEvent me) -> {
            primaryStage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
