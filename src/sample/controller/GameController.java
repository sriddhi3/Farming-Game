package sample.controller;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import sample.controller.config.Difficulties;
import sample.controller.config.Seasons;
import sample.controller.config.Seeds;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameController {

    private final Group root;

    /**
     * Game Controller constructor that takes in input from teh ConfigGame object
     * @param name name of the player
     * @param diff difficulty of the game
     * @param seeds seed to start with
     * @param startingSeason season at the start
     */
    public GameController(String name, Difficulties diff, Seeds seeds, Seasons startingSeason) {
        root = new Group();

        int money = diff.getStartingMoney();
        int day = 0;

        for (int i = 0; i < 5; i++) {
            Rectangle tile = newTile();
            tile.setX(i * 70);
            root.getChildren().add(tile);
        }

        for (int i = 0; i < 5; i++) {
            Rectangle tile = newTile();
            tile.setX(i * 70);
            tile.setY(70);
            root.getChildren().add(tile);
        }

        for (int i = 0; i < 5; i++) {
            Rectangle tile = newTile();
            tile.setX(i * 70);
            tile.setY(140);
            root.getChildren().add(tile);
        }

        for (int i = 0; i < 5; i++) {
            Rectangle tile = newTile();
            tile.setX(i * 70);
            tile.setY(210);
            root.getChildren().add(tile);
        }

        for (int i = 0; i < 5; i++) {
            Rectangle tile = newTile();
            tile.setX(i * 70);
            tile.setY(280);
            root.getChildren().add(tile);
        }

        Label moneyLabel = new Label("Money: " + money);
        root.getChildren().add(moneyLabel);
        moneyLabel.setTranslateX(420);
        moneyLabel.setTranslateY(470);

        Label dateLabel = new Label("Day: " + day);
        root.getChildren().add(dateLabel);
        dateLabel.setTranslateX(20);
        dateLabel.setTranslateY(470);
    }

    /**
     * Creates new brown tile with green edges and returns it
     * @return rectangle object
     */
    public Rectangle newTile() {
        Rectangle r = new Rectangle();
        r.setWidth(70);
        r.setHeight(70);
        r.setFill(Color.SADDLEBROWN);
        r.setStroke(Color.GREEN);
        return r;
    }

    /**
     * The show method that displays the scene
     * @param scene The scene to be displayed
     */
    public void show(Scene scene) {
        scene.setRoot(root);
    }
}