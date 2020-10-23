package view;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Crop;
import model.Inventory;
import model.Item;
import model.Seed;

public class MarketController implements Initializable {

    @FXML
    private TableColumn<String, Crop> iItem;
    @FXML
    private TableColumn<Integer, Crop> iPrice;
    @FXML
    private TableColumn<String, Crop> iType;
    @FXML
    private TableColumn<Integer, Crop> quantity;
    @FXML
    private TableView<Crop> inventoryTable;
    @FXML
    private TableView<Item> marketTable;
    @FXML
    private TableColumn<String, Item> mItem;
    @FXML
    private TableColumn<String, Item> mPrice;

    @FXML
    private Label capacity;
    @FXML
    private Label money;

    @FXML
    private TableView<Seed> seedTable;
    @FXML
    private TableColumn<String, Seed> seedCol;
    @FXML
    private TableColumn<String, Seed> priceCol;
    @FXML
    private RadioButton itemR;
    @FXML
    private ToggleGroup table;
    @FXML
    private RadioButton seedR;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        capacity.setText("Capacity: " + (Inventory.getTotal()
                - Inventory.getCapacity()) + "/" + Inventory.getTotal());
        money.setText("Money: " + Farming.getTotalMoney());
        //        if(Farming.inventory_check){
        inventory();
        //            Farming.inventory_check = false;
        //        }
    }

    @FXML
    private void sell(ActionEvent event) {
        Crop selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        int index = inventoryTable.getSelectionModel().getSelectedIndex();
        try {
            Farming.setTotalMoney(Farming.getTotalMoney()
                    + selectedItem.getPrice() * selectedItem.getQuantity());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Select a row in inventory table ");
            return;
        }

        inventoryTable.getItems().remove(selectedItem);
        money.setText("Money: " + Farming.getTotalMoney());
        Inventory.setCapacity(Inventory.getCapacity() + selectedItem.getQuantity());
        capacity.setText("Capacity: " + (Inventory.getTotal()
                - Inventory.getCapacity()) + "/" + Inventory.getTotal());
    }

    @FXML
    private void buy(ActionEvent event) {

        if (itemR.isSelected()) {
            Item selectedItem = marketTable.getSelectionModel().getSelectedItem();
            String itemName;
            try {
                itemName = selectedItem.getName();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Select an item in item table ");
                return;
            }

            int itemPrice = selectedItem.getPrice();
            String q = JOptionPane.showInputDialog("Enter Quantity");
            if (itemPrice * Integer.parseInt(q) <= Farming.getTotalMoney()) {
                if (Inventory.getCapacity() < Integer.parseInt(q)) {
                    JOptionPane.showMessageDialog(null, "Not enough capacity");
                    return;
                }
                int updateCap = Inventory.getCapacity() - Integer.parseInt(q);
                Inventory.setCapacity(updateCap);
                //                Inventory.setCapacity(Inventory.getCapacity() + Integer.parseInt(q));
                Farming.setTotalMoney(Farming.getTotalMoney() - itemPrice * Integer.parseInt(q));
                money.setText("Money: " + Farming.getTotalMoney());
                capacity.setText("Capacity: " + (Inventory.getTotal()
                        - Inventory.getCapacity()) + "/" + Inventory.getTotal());

            } else {
                JOptionPane.showMessageDialog(null, "not enough money");
                return;
            }

            Inventory.crops.add(new Crop(itemName, itemPrice, Integer.parseInt(q), "Item"));
        } else if (seedR.isSelected()) {
            Seed selectedItem = seedTable.getSelectionModel().getSelectedItem();
            String seedName;
            try {
                seedName = selectedItem.getName();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Select a seed in seed table ");
                return;
            }

            int seedPrice = selectedItem.getQuantity();
            String q = JOptionPane.showInputDialog("Enter Quantity");
            if (seedPrice * Integer.parseInt(q) <= Farming.getTotalMoney()) {
                if (Inventory.getCapacity() < Integer.parseInt(q)) {
                    JOptionPane.showMessageDialog(null, "Not enough capacity");
                    return;
                }
                int updateCap = Inventory.getCapacity() - Integer.parseInt(q);
                Inventory.setCapacity(updateCap);
                Farming.setTotalMoney(Farming.getTotalMoney() - seedPrice * Integer.parseInt(q));
                money.setText("Money: " + Farming.getTotalMoney());
                capacity.setText("Capacity: " + (Inventory.getTotal()
                        - Inventory.getCapacity()) + "/" + Inventory.getTotal());
            } else {
                JOptionPane.showMessageDialog(null, "not enough money");
                return;
            }

            Inventory.crops.add(new Crop(seedName, seedPrice, Integer.parseInt(q), "Crop"));
            Inventory.seeds.add(new Seed(seedName));
            Farming.setInventoryCheck(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a radio button");
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

    void inventory() {
        if (Farming.isMarketCheck()) {
        //            fill();
            Farming.setMarketCheck(false);
        }
        iItem.setCellValueFactory(new PropertyValueFactory<>("name"));
        iPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        iType.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventoryTable.setItems(Inventory.crops);
        mItem.setCellValueFactory(new PropertyValueFactory<>("name"));
        mPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        marketTable.setItems(Farming.items);
        seedCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        seedTable.setItems(Farming.seed);
    }

    static void fill() {
        int q;
        try {
            q = Inventory.seeds.get(0).getQuantity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Select a seed in seed table ");
            return;
        }

        String cropName = Inventory.seeds.get(0).getName();
        int price = Farming.getPrice() * 10;
        Inventory.crops.add(new Crop(cropName, price, q));

    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        int price;
        int index;
        if (seedR.isSelected()) {
            Seed selectedItem = seedTable.getSelectionModel().getSelectedItem();
            try {
                price = Integer.parseInt(JOptionPane.showInputDialog("Enter New Price For "
                        + selectedItem.getName()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Select aa seed in seed table ");
                return;
            }

            index = seedTable.getSelectionModel().getSelectedIndex();
            Farming.seed.get(index).setQuantity(price);
            Parent tableView = FXMLLoader.load(getClass().getResource("initial_UI.fxml"));
            Scene tableViewscene = new Scene(tableView);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewscene);
            window.show();
        } else if (itemR.isSelected()) {
            Item selectedItem = marketTable.getSelectionModel().getSelectedItem();
            try {
                price = Integer.parseInt(JOptionPane.showInputDialog("Enter New Price For "
                        + selectedItem.getName()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Select an item in item table ");
                return;
            }
            index = marketTable.getSelectionModel().getSelectedIndex();
            Farming.items.get(index).setPrice(price);
            Parent tableView = FXMLLoader.load(getClass().getResource("initial_UI.fxml"));
            Scene tableViewscene = new Scene(tableView);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewscene);
            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a radio button");
        }

    }

}
