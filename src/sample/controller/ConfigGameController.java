package sample.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.controller.config.Difficulties;
import sample.controller.config.Seasons;
import sample.controller.config.Seeds;

/**
 * Controller for our configuration screen.
 */
public class ConfigGameController {

    private BorderPane configScreen;

    private TextField nameTextField;

    private ToggleGroup difficultyGroup;

    private ToggleGroup startingSeedGroup;

    private ToggleGroup startingSeasonGroup;

    private GameController gameController;

    private Difficulties selectedDifficulty;

    private Seeds selectedSeed;

    private Seasons selectedSeason;

    /**
     * Constructs a new configuration scene
     */
    public ConfigGameController() {
        configScreen = new BorderPane();

        // Create the overall settings VBox
        VBox settings = new VBox();
        settings.setPrefHeight(700);
        settings.setAlignment(Pos.CENTER);
        settings.setPadding(new Insets(40));
        settings.setSpacing(20);
        configScreen.setCenter(settings);

        // Create the name text field
        nameTextField = new TextField();
        nameTextField.setPromptText("Name");
        settings.getChildren().add(nameTextField);

        // Create the HBox for the starting options
        HBox startingOptions = new HBox();
        startingOptions.setPadding(new Insets(10));
        startingOptions.setAlignment(Pos.CENTER);
        settings.getChildren().add(startingOptions);

        // Create the difficulty options
        VBox difficultyButtons = new VBox();
        difficultyButtons.setAlignment(Pos.TOP_LEFT);
        difficultyButtons.setPadding(new Insets(10));
        startingOptions.getChildren().add(difficultyButtons);

        Label difficultyLabel = new Label("Difficulty");
        difficultyButtons.getChildren().add(difficultyLabel);
        difficultyGroup = new ToggleGroup();

        RadioButton easyButton = new RadioButton("Easy");
        easyButton.setToggleGroup(difficultyGroup);
        easyButton.setOnAction(event -> selectedDifficulty = Difficulties.EASY);
        difficultyButtons.getChildren().add(easyButton);
        easyButton.setSelected(true);

        RadioButton mediumButton = new RadioButton("Medium");
        mediumButton.setToggleGroup(difficultyGroup);
        mediumButton.setOnAction(event -> selectedDifficulty = Difficulties.MEDIUM);
        difficultyButtons.getChildren().add(mediumButton);

        RadioButton hardButton = new RadioButton("Hard");
        hardButton.setToggleGroup(difficultyGroup);
        hardButton.setOnAction(event -> selectedDifficulty = Difficulties.HARD);
        difficultyButtons.getChildren().add(hardButton);

        // Create starting seed options
        VBox seedButtons = new VBox();
        seedButtons.setAlignment(Pos.TOP_LEFT);
        seedButtons.setPadding(new Insets(10));
        startingOptions.getChildren().add(seedButtons);

        Label seedLabel = new Label("Starting Seed");
        seedButtons.getChildren().add(seedLabel);
        startingSeedGroup = new ToggleGroup();

        RadioButton wheatButton = new RadioButton("Wheat");
        wheatButton.setToggleGroup(startingSeedGroup);
        wheatButton.setOnAction(event -> selectedSeed = Seeds.WHEAT);
        seedButtons.getChildren().add(wheatButton);
        wheatButton.setSelected(true);

        RadioButton cornButton = new RadioButton("Corn");
        cornButton.setOnAction(event -> selectedSeed = Seeds.CORN);
        cornButton.setToggleGroup(startingSeedGroup);
        seedButtons.getChildren().add(cornButton);

        RadioButton beansButton = new RadioButton("Beans");
        cornButton.setOnAction(event -> selectedSeed = Seeds.BEANS);
        beansButton.setToggleGroup(startingSeedGroup);
        seedButtons.getChildren().add(beansButton);

        // Create starting seasons options
        VBox seasonButtons = new VBox();
        seasonButtons.setAlignment(Pos.TOP_LEFT);
        seasonButtons.setPadding(new Insets(10));
        startingOptions.getChildren().add(seasonButtons);

        Label seasonLabel = new Label("Starting Season");
        seasonButtons.getChildren().add(seasonLabel);
        startingSeasonGroup = new ToggleGroup();

        RadioButton springButton = new RadioButton("Spring");
        springButton.setToggleGroup(startingSeasonGroup);
        seasonButtons.getChildren().add(springButton);
        springButton.setOnAction(event -> selectedSeason = Seasons.SPRING);
        springButton.setSelected(true);

        RadioButton summerButton = new RadioButton("Summer");
        summerButton.setToggleGroup(startingSeasonGroup);
        springButton.setOnAction(event -> selectedSeason = Seasons.SUMMER);
        seasonButtons.getChildren().add(summerButton);

        RadioButton fallButton = new RadioButton("Fall");
        fallButton.setToggleGroup(startingSeasonGroup);
        seasonButtons.getChildren().add(fallButton);
        springButton.setOnAction(event -> selectedSeason = Seasons.FALL);
        fallButton.setSelected(true);

        RadioButton winterButton = new RadioButton("Winter");
        winterButton.setToggleGroup(startingSeasonGroup);
        springButton.setOnAction(event -> selectedSeason = Seasons.WINTER);
        seasonButtons.getChildren().add(winterButton);

        Button newGameButton = new Button("New Game");
        settings.getChildren().add(newGameButton);

        newGameButton.setOnAction(event -> {
            boolean nameIsValid = isValidName(getName());
            if (nameIsValid) {
                gameController = new GameController(getName(), selectedDifficulty, selectedSeed, selectedSeason);
                gameController.show(configScreen.getScene());
            }
        });
    }

    /**
     * Sets the config screen to display on the scene
     * @param scene the scene to display the config screen
     */
    public void show(Scene scene) {
        scene.setRoot(configScreen);
    }

    /**
     * Returns the given name
     * @return string in the name text field
     */
    public String getName() {
        return nameTextField.getText();
    }

    /**
     * Sets the name for the name text field
     * @param name the name string in the name text field
     */
    public void setName(String name) {
        nameTextField.setText(name);
    }

    /**
     * Checks if the name is valid. A valid name
     * is neither null, empty, nor blank.
     * @param name the name to check if valid
     * @return true if valid, false otherwise
     */
    public boolean isValidName(String name) {
        return name.trim().length() >= 1;
    }
}
