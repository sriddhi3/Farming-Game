/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Inventory;
import model.Seed;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sheikh Munim
 */
public class ConfigScreenController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private RadioButton easyR;
    @FXML
    private ToggleGroup difficulty;
    @FXML
    private RadioButton mediumR;
    @FXML
    private RadioButton hardR;
    @FXML
    private RadioButton wheatR;
    @FXML
    private ToggleGroup seeds;
    @FXML
    private RadioButton riceR;
    @FXML
    private RadioButton cornR;
    @FXML
    private RadioButton springR;
    @FXML
    private ToggleGroup season;
    @FXML
    private RadioButton summerR;
    @FXML
    private RadioButton fallR;
    @FXML
    private RadioButton winterR;
    @FXML
    private RadioButton potato;
    @FXML
    private RadioButton cabbage;
    private boolean seasonCheck = false;
    private boolean seedCheck = false;
    private boolean dificultyCheck = false;
    @FXML
    private RadioButton onion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        Farming.setPlayerName(name.getText());
        if (!name.getText().equals("")) {
            if (seasonCheck) {
                if (seedCheck) {
                    if (!dificultyCheck) {
                        JOptionPane.showMessageDialog(null, "Select a difficulty first");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select a seed first");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select a season first");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter your name first");
            return;
        }
        Farming.fillItems();
        Parent tableView = FXMLLoader.load(getClass().getResource("initial_UI.fxml"));
        Scene tableViewscene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewscene);
        window.show();
    }

    @FXML
    private void easy(ActionEvent event) {
        //        Farming.selectedDifficulty = "easy";
        Farming.setSelectedDifficulty("easy");
        Farming.setTotalMoney(300);
        Farming.setPricingFactor(1);
        Inventory.setCapacity(30);
        Inventory.setTotal(30);
        dificultyCheck = true;
    }

    @FXML
    private void medium(ActionEvent event) {
        //        Farming.selectedDifficulty = "medium";
        Farming.setSelectedDifficulty("medium");
        Farming.setTotalMoney(200);
        Farming.setPricingFactor(2);
        Inventory.setCapacity(30);
        Inventory.setTotal(30);
        dificultyCheck = true;
    }

    @FXML
    private void hard(ActionEvent event) {
        //        Farming.selectedDifficulty = "hard";
        Farming.setSelectedDifficulty("hard");
        Farming.setTotalMoney(100);
        Farming.setPricingFactor(3);
        Inventory.setCapacity(30);
        Inventory.setTotal(30);
        dificultyCheck = true;
    }

    @FXML
    private void wheat(ActionEvent event) {
        //        Farming.selectedSeed = "wheat";
        Farming.setSelectedSeed("wheat");
        Inventory.seeds.add(new Seed(0, "Wheat"));
        Farming.setPrice(2);
        seedCheck = true;
    }

    @FXML
    private void rice(ActionEvent event) {
        //        Farming.selectedSeed = "rice";
        Farming.setSelectedSeed("rice");
        Inventory.seeds.add(new Seed(0, "Rice"));
        Farming.setPrice(2);
        seedCheck = true;
    }

    @FXML
    private void corn(ActionEvent event) {
        //        Farming.selectedSeed = "corn";
        Farming.setSelectedSeed("corn");
        Inventory.seeds.add(new Seed(0, "Corn"));
        Farming.setPrice(3);
        seedCheck = true;
    }

    @FXML
    private void potato(ActionEvent event) {
        //        Farming.selectedSeed = "potato";
        Farming.setSelectedSeed("potato");
        Inventory.seeds.add(new Seed(0, "potato"));
        Farming.setPricingFactor(4);
        seedCheck = true;
    }

    @FXML
    private void onion(ActionEvent event) {
        //        Farming.selectedSeed = "onion";
        Farming.setSelectedSeed("onion");
        Inventory.seeds.add(new Seed(0, "Onion"));
        Farming.setPrice(5);
        seedCheck = true;
    }

    @FXML
    private void cabbage(ActionEvent event) {
        //        Farming.selectedSeed = "cabbage";
        Farming.setSelectedSeed("cabbage");
        Farming.getInventory().seeds.add(new Seed(0, "Cabbage"));
        Farming.setPrice(7);
        seedCheck = true;

    }

    @FXML
    private void spring(ActionEvent event) {
        Farming.setSelectedSeason("spring");
        seasonCheck = true;
    }

    @FXML
    private void summer(ActionEvent event) {
        Farming.setSelectedSeason("summer");
        seasonCheck = true;
    }

    @FXML
    private void fall(ActionEvent event) {
        Farming.setSelectedSeason("fall");
        seasonCheck = true;
    }

    @FXML
    private void winter(ActionEvent event) {
        Farming.setSelectedSeason("winter");
        seasonCheck = true;
    }

}
