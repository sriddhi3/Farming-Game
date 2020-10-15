/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static view.MarketController.fill;
import model.Crop;
import model.Inventory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sheikh Munim
 */
public class InventoryController implements Initializable {

    @FXML
    private TableView<Crop> harvestedCrops;
    @FXML
    private TableColumn<String, Crop> crop;
    @FXML
    private TableColumn<String, Crop> number;
    @FXML
    private ListView<String> seedsTable;
    @FXML
    private ListView<String> itemsTable;
    @FXML
    private Label capacity;
    static ObservableList<Crop> cropCist = FXCollections.observableArrayList();
    static ObservableList<String> seed = FXCollections.observableArrayList();
    static ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        capacity.setText(capacity.getText() + " " + (Inventory.getTotal()
                - Inventory.getCapacity()) + "/" + Inventory.getTotal());
        fillInventory();
        if (Farming.isMarketCheck()) {
            fill();
            Farming.setMarketCheck(false);
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("initial_UI.fxml"));
        Scene tableViewscene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewscene);
        window.show();
    }

    private void fillInventory() {
        if (Farming.isInventoryCheck2()) {
            items.addAll("Compost", "Sickle", "Scare Crow", "Wagon", "Fence");
            Farming.setInventoryCheck2(false);
        }
        if (Farming.isInventoryCheck()) {
            fillList();
            Farming.setInventoryCheck(false);
        }
        crop.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        harvestedCrops.setItems(Inventory.crops);
        seedsTable.setItems(seed);
        itemsTable.setItems(items);
    }

    public void fillList() {
        seed.clear();
        Inventory.seeds.forEach(x -> {
            seed.add(x.getName());
        });
    }

}
