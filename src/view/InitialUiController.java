package view;

import model.Inventory;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InitialUiController implements Initializable {

    @FXML
    private Rectangle box00;
    @FXML
    private Rectangle box01;
    @FXML
    private Rectangle box03;
    @FXML
    private Rectangle box10;
    @FXML
    private Rectangle box11;
    @FXML
    private Rectangle box12;
    @FXML
    private Rectangle box13;
    @FXML
    private Rectangle box20;
    @FXML
    private Rectangle box21;
    @FXML
    private Rectangle box22;
    @FXML
    private Rectangle box23;
    @FXML
    private Rectangle box30;
    @FXML
    private Rectangle box31;
    @FXML
    private Rectangle box32;
    @FXML
    private Rectangle box33;
    @FXML
    private Label money;
    @FXML
    private Rectangle box02;

    private final String emptyField = "f8dfdf";
    private final String seedField = "c9b09e";
    private final String immatureField = "00ff00";
    private final String matureField = "83a152";
    private int[][] colors = Farming.colors;
    @FXML
    private Label season;
    @FXML
    private Label playerName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        season.setText("Season: " + Farming.getSelectedSeason());
        money.setText("Money: " + Farming.getTotalMoney());
        playerName.setText("Player: " + Farming.getPlayerName());

        fillFarm();

    }

    @FXML
    private void box00ClickEvent(MouseEvent event) {

        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box00.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box00.setFill(javafx.scene.paint.Color.web(emptyField));
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            Inventory.crops.get(0).setQuantity(Inventory.crops.get(0).getQuantity() + 1);
            colors[0][0] = 1;
        }

    }

    @FXML
    private void box01Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box01.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box01.setFill(javafx.scene.paint.Color.web(emptyField));
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            Inventory.seeds.get(0).setQuantity(Inventory.seeds.get(0).getQuantity() + 1);
            colors[0][1] = 1;
        }
    }

    @FXML
    private void box02Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box02.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box02.setFill(javafx.scene.paint.Color.web(emptyField));
            Inventory.seeds.get(0).setQuantity(Inventory.seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[0][2] = 1;
        }
    }

    @FXML
    private void box03Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box03.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box03.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[0][3] = 1;
        }
    }

    @FXML
    private void box10Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box10.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box10.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[1][0] = 1;
        }
    }

    @FXML
    private void box11Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box11.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box11.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[1][1] = 1;
        }
    }

    @FXML
    private void box12Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box12.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box12.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[1][2] = 1;
        }
    }

    @FXML
    private void box13Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box13.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box13.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[1][3] = 1;
        }
    }

    @FXML
    private void box20Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box20.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box20.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[2][0] = 1;
        }
    }

    @FXML
    private void box21Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box21.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box21.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[2][1] = 1;
        }
    }

    @FXML
    private void box22Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box22.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box22.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[2][2] = 1;
        }
    }

    @FXML
    private void box23Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box23.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box23.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[2][3] = 1;
        }
    }

    @FXML
    private void box30Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box30.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box30.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[3][0] = 1;
        }
    }

    @FXML
    private void box31Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box31.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box31.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[3][1] = 1;
        }
    }

    @FXML
    private void box32Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box32.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box32.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.getInventory().seeds.get(0).setQuantity(Farming.getInventory()
                    .seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[3][2] = 1;
        }
    }

    @FXML
    private void box33Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box33.getFill() + "").substring(2, 8);
        if (checkColor(c)) {
            box33.setFill(javafx.scene.paint.Color.web(emptyField));
            Inventory.seeds.get(0).setQuantity(Inventory.seeds.get(0).getQuantity() + 1);
            Inventory.setCapacity(Inventory.getCapacity() - 1);
            colors[3][3] = 1;
        }
    }

    @FXML
    private void inventory(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        Scene tableViewscene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewscene);
        window.show();
    }

    @FXML
    private void market(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("Market.fxml"));
        Scene tableViewscene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewscene);
        window.show();
    }

    private void fillFarm() {
        int randomColor;
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((3 * Math.random()));
            colors[0][0] = randomColor;
        } else {
            randomColor = colors[0][0];
        }
        switch (randomColor) {
        case 1:
            box00.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box00.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box00.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box00.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][1] = randomColor;
        } else {
            randomColor = colors[0][1];
        }
        switch (randomColor) {
        case 1:
            box01.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box01.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box01.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box01.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][2] = randomColor;
        } else {
            randomColor = colors[0][2];
        }
        switch (randomColor) {
        case 1:
            box02.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box02.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box02.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box02.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][3] = randomColor;
        } else {
            randomColor = colors[0][3];
        }
        switch (randomColor) {
        case 1:
            box03.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box03.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box03.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box03.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][0] = randomColor;
        } else {
            randomColor = colors[1][0];
        }
        switch (randomColor) {
        case 1:
            box10.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box10.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box10.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box10.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][1] = randomColor;
        } else {
            randomColor = colors[1][1];
        }
        switch (randomColor) {
        case 1:
            box11.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box11.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box11.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box11.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][2] = randomColor;
        } else {
            randomColor = colors[1][2];
        }
        switch (randomColor) {
        case 1:
            box12.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box12.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box12.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box12.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][3] = randomColor;
        } else {
            randomColor = colors[1][3];
        }
        switch (randomColor) {
        case 1:
            box13.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box13.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box13.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box13.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][0] = randomColor;
        } else {
            randomColor = colors[2][0];
        }
        switch (randomColor) {
        case 1:
            box20.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box20.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box20.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box20.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][1] = randomColor;
        } else {
            randomColor = colors[2][1];
        }
        switch (randomColor) {
        case 1:
            box21.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box21.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box21.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box21.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][2] = randomColor;
        } else {
            randomColor = colors[2][2];
        }
        switch (randomColor) {
        case 1:
            box22.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box22.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box22.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box22.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][3] = randomColor;
        } else {
            randomColor = colors[2][3];
        }
        switch (randomColor) {
        case 1:
            box23.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box23.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box23.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box23.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][0] = randomColor;
        } else {
            randomColor = colors[3][0];
        }
        switch (randomColor) {
        case 1:
            box30.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box30.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box30.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box30.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][1] = randomColor;
        } else {
            randomColor = colors[3][1];
        }
        switch (randomColor) {
        case 1:
            box31.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box31.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box31.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box31.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][2] = randomColor;
        } else {
            randomColor = colors[3][2];
        }
        switch (randomColor) {
        case 1:
            box32.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box32.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box32.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box32.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][3] = randomColor;
        } else {
            randomColor = colors[3][3];
        }
        switch (randomColor) {
        case 1:
            box33.setFill(javafx.scene.paint.Color.web(emptyField));
            break;
        case 2:
            box33.setFill(javafx.scene.paint.Color.web(seedField));
            break;
        case 3:
            box33.setFill(javafx.scene.paint.Color.web(immatureField));
            break;
        case 4:
            box33.setFill(javafx.scene.paint.Color.web(matureField));
            break;
        default:
            break;

        }
        Farming.setStart(false);
    }

    private boolean checkColor(String color) {
        return color.equals(matureField);
    }

    void show() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(colors[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
