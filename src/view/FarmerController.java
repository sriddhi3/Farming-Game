package view;

import static view.Farming.isHired;
import static view.Farming.setHireDays;
import static view.Farming.setMature;
import static view.Farming.setHired;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FarmerController implements Initializable {

    @FXML
    private RadioButton d1;
    @FXML
    private ToggleGroup days;
    @FXML
    private RadioButton d7;
    @FXML
    private RadioButton d14;
    @FXML
    private RadioButton matureF;
    @FXML
    private ToggleGroup type;
    @FXML
    private RadioButton immatureF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("initial_UI.fxml"));
        Scene tableViewscene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewscene);
        window.show();
    }

    @FXML
    private void hire(ActionEvent event) {
        if(isHired()){
            JOptionPane.showMessageDialog(null, "Farmer is already hired!");
            return;
        }
        if(d1.isSelected()){
            setHireDays(1);
        }else if (d7.isSelected()){
            setHireDays(7);
        }else if (d14.isSelected()){
            setHireDays(14);
        }else {
            JOptionPane.showMessageDialog(null, "Please select days");
            return;
        }
        if(matureF.isSelected()){
            setMature(true);
        }else if(immatureF.isSelected()){
            setMature(false);
        }else {
            JOptionPane.showMessageDialog(null, "Please select farmer type");
            return;
        }
        setHired(true);
        JOptionPane.showMessageDialog(null, "Farmer hired!");
    }
    
}
