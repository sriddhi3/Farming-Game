package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.controller.ConfigGameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Main entrypoint for farm game project.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane stackPane = new StackPane();
        primaryStage.setTitle("Farm Guys");
        Scene scene = new Scene(stackPane, 500, 500);
        primaryStage.setScene(scene);

        ConfigGameController configGameController = new ConfigGameController();

        Button startButton = new Button("Start");
        stackPane.getChildren().add(startButton);
        startButton.setOnAction(event -> configGameController.show(scene));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
