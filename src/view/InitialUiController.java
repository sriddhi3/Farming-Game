package view;

import static model.Inventory.crops;
import model.Crop;
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
    @FXML
    private Label date;
    @FXML
    private Label season;
    @FXML
    private Label playerName;
    @FXML
    private Label lb00;
    @FXML
    private Label lb01;
    @FXML
    private Label lb02;
    @FXML
    private Label lb03;
    @FXML
    private Label lb10;
    @FXML
    private Label lb11;
    @FXML
    private Label lb12;
    @FXML
    private Label lb13;
    @FXML
    private Label lb20;
    @FXML
    private Label lb21;
    @FXML
    private Label lb22;
    @FXML
    private Label lb23;
    @FXML
    private Label lb30;
    @FXML
    private Label lb31;
    @FXML
    private Label lb32;
    @FXML
    private Label lb33;
    @FXML
    private Label userWater;
    @FXML
    private Label wvalue00;
    @FXML
    private Label wvalue01;
    @FXML
    private Label wvalue02;
    @FXML
    private Label wvalue03;
    @FXML
    private Label wvalue10;
    @FXML
    private Label wvalue11;
    @FXML
    private Label wvalue12;
    @FXML
    private Label wvalue13;
    @FXML
    private Label wvalue20;
    @FXML
    private Label wvalue21;
    @FXML
    private Label wvalue22;
    @FXML
    private Label wvalue23;
    @FXML
    private Label wvalue30;
    @FXML
    private Label wvalue31;
    @FXML
    private Label wvalue32;
    @FXML
    private Label wvalue33;

    private final String emptyField = "f8dfdf";
    private final String seedField = "c9b09e";
    private final String immatureField = "00ff00";
    private final String matureField = "83a152";
    private final String deadFied = "303c19";
    private final int[][] colors = Farming.colors;
    private final int maxWaterLimit = Farming.getMaxWaterLvel();
    private int userWate = Farming.farm.getUserWater();
    private final int totalWater = Farming.farm.getTotalWater();
    private final int dayCount = Farming.getDayCount();
    //    Rectangle[] boxes = {box00, box01, box02, box03, box10, box11,
    //    box12, box13, box20, box21, box22, box23, box30, box31, box32, box33};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        season.setText("Season: " + Farming.getSelectedSeason());
        money.setText("Money: " + Farming.getTotalMoney());
        playerName.setText("Player: " + Farming.getPlayerName());
        date.setText("Day " + Farming.getDay());
        lb00.setText(seedField);
        setWaterLevel();
        //        if(Farming.isIuiCheck()){
        fillFarm();
        setLabelText();
        //            Farming.setIuiCheck(false);
        //        }

        //        show();
    }

    ///////////////////////////////////////////////////////////////
    private void removeEmptyPlot(Label lb, Rectangle rec, Label wvalue, int i, int j) {
        // harvest crop and set label to empty
        lb.setText("empty");
        // Set field color to emty
        rec.setFill(javafx.scene.paint.Color.web(emptyField));
        // set wvalue to 0
        wvalue.setText("0");
        Inventory.setCapacity(Inventory.getCapacity() - 1);
        //        try {
        //            Inventory.crops.get(0).setQuantity(Inventory.crops.get(0).getQuantity() + 1);
        //        } catch (IndexOutOfBoundsException ex) {
        ////                Inventory.crops.get(0).setQuantity(Inventory.crops.get(0).getQuantity() + 1);
        //        }
        colors[i][j] = 1;
    }

    @FXML
    private void box00ClickEvent(MouseEvent event) {
        // if Inventory is full
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box00;
        Label lb = lb00;
        Label wv = wvalue00;
        int i = 0;
        int j = 0;
        boxAction(rec, lb, wv, i, j);
        //        String c = (box00.getFill() + "").substring(2, 8);
        //        // a seed is selected from inventory
        //        boolean seedSelected = !Inventory.getSeedToFarm().equalsIgnoreCase("");
        //        // if field is empty
        //        boolean isEmpty = isEmpty(c);
        //        // qty is greater than 0
        //        boolean qty = Inventory.getQty() > 0;
        //        if (seedSelected && isEmpty && qty) {
        //            // decrease qty veriable
        //            Inventory.setQty(Inventory.getQty() - 1);
        //            // change farm color to seed
        //            box00.setFill(javafx.scene.paint.Color.web(seedField));
        //            // change farm state in inventory.crop
        ////            Inventory.crops.
        //            // change seed label to selected seed
        //            lb00.setText(Inventory.getSeedToFarm());
        //            // set water level to 1
        //            wvalue00.setText("1");
        //            // decrease seed qty in Inventory
        //            Inventory.decreaseSeedQty(Inventory.getSeedToFarm());
        //            // save game state
        //            colors[0][0] = 2;
        //            Farming.farm.crops[0][0].setQuantity(1);
        //            Farming.farm.crops[0][0].setName(Inventory.getSeedToFarm());
        //        }
        //        // if farm is mature
        //        if (checkColor(c) || isDead(box00)) {
        //            // harvest crop and set label to empty
        //            lb00.setText("empty");
        //            // Set field color to emty
        //            // set wvalue to 0
        //            wvalue00.setText("0");
        //            Inventory.setCapacity(Inventory.getCapacity() - 1);
        //            try {
        //                if (!isDead(box00)) {
        //                    Inventory.crops.get(0).setQuantity(Inventory.crops.get(0).getQuantity() + 1);
        //                }
        //            } catch (IndexOutOfBoundsException ex) {
        ////                Inventory.crops.get(0).setQuantity(Inventory.crops.get(0).getQuantity() + 1);
        //            }
        //            box00.setFill(javafx.scene.paint.Color.web(emptyField));
        //
        //            colors[0][0] = 1;
        //        }

    }

    @FXML
    private void box01Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box01;
        Label lb = lb01;
        Label wv = wvalue01;
        int i = 0;
        int j = 1;
        boxAction(rec, lb, wv, i, j);
        //        String c = (box01.getFill() + "").substring(2, 8);
        //        // a seed is selected from inventory
        //        boolean seedSelected = !Inventory.getSeedToFarm().equalsIgnoreCase("");
        //        // if field is empty
        //        boolean isEmpty = isEmpty(c);
        //        // qty is greater than 0
        //        boolean qty = Inventory.getQty() > 0;
        //        if (seedSelected && isEmpty && qty) {
        //            // decrease qty veriable
        //            Inventory.setQty(Inventory.getQty() - 1);
        //            // change farm color to seed
        //            box01.setFill(javafx.scene.paint.Color.web(seedField));
        //            // change farm state in inventory.crop
        ////            Inventory.crops.
        //            // change seed label to selected seed
        //            lb01.setText(Inventory.getSeedToFarm());
        //            // set water level to 1
        //            wvalue01.setText("1");
        //            // decrease seed qty in Inventory
        //            Inventory.decreaseSeedQty(Inventory.getSeedToFarm());
        //            colors[0][1] = 2;
        //            Farming.farm.crops[0][1].setQuantity(1);
        //            Farming.farm.crops[0][1].setName(Inventory.getSeedToFarm());
        //        }
        //        // if farm is mature
        //        if (checkColor(c) || isDead(box01)) {
        //            lb01.setText("empty");
        //            wvalue01.setText("0");
        //            Inventory.setCapacity(Inventory.getCapacity() - 1);
        //            if (!isDead(box01)) {
        //                Inventory.seeds.get(0).setQuantity(Inventory.seeds.get(0).getQuantity() + 1);
        //            }
        //            box01.setFill(javafx.scene.paint.Color.web(emptyField));
        //
        //            colors[0][1] = 1;
        //
        //        }
    }

    @FXML
    private void box02Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box02;
        Label lb = lb02;
        Label wv = wvalue02;
        int i = 0;
        int j = 2;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box03Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box03;
        Label lb = lb03;
        Label wv = wvalue03;
        int i = 0;
        int j = 3;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box10Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box10;
        Label lb = lb10;
        Label wv = wvalue10;
        int i = 1;
        int j = 0;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box11Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box11;
        Label lb = lb11;
        Label wv = wvalue11;
        int i = 1;
        int j = 1;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box12Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box12;
        Label lb = lb12;
        Label wv = wvalue12;
        int i = 1;
        int j = 2;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box13Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box13;
        Label lb = lb13;
        Label wv = wvalue13;
        int i = 1;
        int j = 3;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box20Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box20;
        Label lb = lb20;
        Label wv = wvalue20;
        int i = 2;
        int j = 0;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box21Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box21;
        Label lb = lb21;
        Label wv = wvalue21;
        int i = 2;
        int j = 1;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box22Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        String c = (box22.getFill() + "").substring(2, 8);
        // a seed is selected from inventory
        boolean seedSelected = !Inventory.getSeedToFarm().equalsIgnoreCase("");
        // if field is empty
        boolean isEmpty = isEmpty(c);
        // qty is greater than 0
        boolean qty = Inventory.getQty() > 0;
        if (seedSelected && isEmpty && qty) {
            // decrease qty veriable
            Inventory.setQty(Inventory.getQty() - 1);
            // change farm color to seed
            box22.setFill(javafx.scene.paint.Color.web(seedField));
            // change farm state in inventory.crop
            //            Inventory.crops.
            // change seed label to selected seed
            lb22.setText(Inventory.getSeedToFarm());
            // set water level to 1
            wvalue22.setText("1");
            // decrease seed qty in Inventory
            Inventory.decreaseSeedQty(Inventory.getSeedToFarm());
            colors[2][2] = 2;
            Farming.farm.crops[2][2].setQuantity(1);
            Farming.farm.crops[2][2].setName(Inventory.getSeedToFarm());
        }
        // if farm is mature
        if (checkColor(c) || isDead(box22)) {
            wvalue22.setText("0");
            lb22.setText("empty");

            if (!isDead(box22)) {
                Inventory.seeds.get(0).setQuantity(Inventory.seeds.get(0).getQuantity() + 1);
            }
            box22.setFill(javafx.scene.paint.Color.web(emptyField));
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
        Rectangle rec = box23;
        Label lb = lb23;
        Label wv = wvalue23;
        int i = 2;
        int j = 3;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box30Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box30;
        Label lb = lb30;
        Label wv = wvalue30;
        int i = 3;
        int j = 0;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box31Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box31;
        Label lb = lb31;
        Label wv = wvalue31;
        int i = 3;
        int j = 1;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box32Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box32;
        Label lb = lb32;
        Label wv = wvalue32;
        int i = 3;
        int j = 2;
        boxAction(rec, lb, wv, i, j);
    }

    @FXML
    private void box33Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box33;
        Label lb = lb33;
        Label wv = wvalue33;
        int i = 3;
        int j = 3;
        boxAction(rec, lb, wv, i, j);
    }

    void boxAction(Rectangle rec, Label lb, Label wv, int i, int j) {
        String c = (rec.getFill() + "").substring(2, 8);
        // if farm is mature
        if (checkColor(c) || isDead(rec)) {
            if (!isDead(rec)) {
                addCropToInventory(i, j, lb.getText());
            }
            wv.setText("0");
            lb.setText("empty");
            if (!isDead(rec)) {
                Inventory.setCapacity(Inventory.getCapacity() - 1);
            }
            rec.setFill(javafx.scene.paint.Color.web(emptyField));

            colors[i][j] = 1;
            return;
        }

        // a seed is selected from inventory
        boolean seedSelected = !Inventory.getSeedToFarm().equalsIgnoreCase("");
        // if field is empty
        boolean isEmpty = isEmpty(c);
        // qty is greater than 0
        boolean qty = Inventory.getQty() > 0;
        if (seedSelected && isEmpty && qty) {
            // decrease qty veriable
            Inventory.setQty(Inventory.getQty() - 1);
            // change farm color to seed
            rec.setFill(javafx.scene.paint.Color.web(seedField));
            // change farm state in inventory.crop
            // change seed label to selected seed
            lb.setText(Inventory.getSeedToFarm());
            // set water level to 1
            wv.setText("1");
            // decrease seed qty in Inventory
            Inventory.decreaseSeedQty(Inventory.getSeedToFarm());
            colors[i][j] = 2;
            Farming.farm.crops[i][j].setQuantity(1);
            Farming.farm.crops[i][j].setName(Inventory.getSeedToFarm());
            incCapacity();
        }
        //        addCropToInventory(i, j, lb.getText());
    }

    void incCapacity(){
        Inventory.setCapacity(Inventory.getCapacity() + 1);
    }
    void decCapacity(){
        Inventory.setCapacity(Inventory.getCapacity() - 1);
    }
    void addCropToInventory(int i, int j, String cropName) {
        for (Crop x : crops) {
            if (x.getName().equalsIgnoreCase(cropName)) {
                x.setQuantity(x.getQuantity() + 1);
                return;
            }
        }

        crops.add(new Crop(cropName, 1, 1, "Crop"));

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

    @FXML
    private void well(ActionEvent event) {
        if (userWate + 1 > totalWater) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        userWate++;
        Farming.farm.setUserWater(Farming.farm.getUserWater() + 1);
        //        Farming.farm.setUserWater(Farming.farm.getUserWater() + 1);
        setWaterLevel();
    }

    private void fillFarm() {
        int randomColor;
        if (Farming.isStart()) {
            lb00.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((3 * Math.random()));
            colors[0][0] = randomColor;
        } else {
            randomColor = colors[0][0];
        }
        switch (randomColor) {
        case 1:
            box00.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[0][0].setState(0);
            Farming.farm.crops[0][0].setName(Farming.getState(0));
            Farming.farm.crops[0][0].setQuantity(0);
            break;
        case 2:
            box00.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[0][0].setState(1);
            break;
        case 3:
            box00.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[0][0].setState(2);
            break;
        case 4:
            box00.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[0][0].setState(3);
            break;
        case 5:
            box00.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[0][0].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb01.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][1] = randomColor;
        } else {
            randomColor = colors[0][1];
        }
        switch (randomColor) {
        case 1:
        //                lb01.setText("empty");
        //                wvalue01.setText("0");
            Farming.farm.crops[0][1].setQuantity(0);
            box01.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[0][1].setName(Farming.getState(0));
            Farming.farm.crops[0][1].setState(0);
            break;
        case 2:
            box01.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[0][1].setState(1);
            break;
        case 3:
            box01.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[0][1].setState(2);
            break;
        case 4:
            box01.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[0][1].setState(3);
            break;
        case 5:
            box01.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[0][1].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb02.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][2] = randomColor;
        } else {
            randomColor = colors[0][2];
        }
        switch (randomColor) {
        case 1:
        //                lb02.setText("empty");
        //                wvalue02.setText("0");
            Farming.farm.crops[0][2].setQuantity(0);
            box02.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[0][2].setName(Farming.getState(0));
            Farming.farm.crops[0][2].setState(0);
            break;
        case 2:
            box02.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[0][2].setState(1);
            break;
        case 3:
            box02.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[0][2].setState(2);
            break;
        case 4:
            box02.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[0][2].setState(3);
            break;
        case 5:
            box02.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[0][2].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb03.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[0][3] = randomColor;
        } else {
            randomColor = colors[0][3];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[0][3].setQuantity(0);
            //                lb03.setText("empty");
            //                wvalue03.setText("0");
            box03.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[0][3].setName(Farming.getState(0));
            Farming.farm.crops[0][3].setState(0);
            break;
        case 2:
            box03.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[0][3].setState(1);
            break;
        case 3:
            box03.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[0][3].setState(2);
            break;
        case 4:
            box03.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[0][3].setState(3);
            break;
        case 5:
            box03.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[0][3].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb10.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][0] = randomColor;
        } else {
            randomColor = colors[1][0];
        }
        switch (randomColor) {
        case 1:
            //                lb10.setText("empty");
            //                wvalue10.setText("0");
            Farming.farm.crops[1][0].setQuantity(0);
            box10.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[1][0].setName(Farming.getState(0));
            Farming.farm.crops[1][0].setState(0);
            break;
        case 2:
            box10.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[1][0].setState(1);
            break;
        case 3:
            box10.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[1][0].setState(2);
            break;
        case 4:
            box10.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[1][0].setState(3);
            break;
        case 5:
            box10.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[1][0].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb11.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][1] = randomColor;
        } else {
            randomColor = colors[1][1];
        }
        switch (randomColor) {
        case 1:
            //                lb11.setText("empty");
            //                wvalue11.setText("0");
            Farming.farm.crops[1][1].setQuantity(0);
            box11.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[1][1].setName(Farming.getState(0));
            Farming.farm.crops[1][1].setState(0);
            break;
        case 2:
            box11.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[1][1].setState(1);
            break;
        case 3:
            box11.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[1][1].setState(2);
            break;
        case 4:
            box11.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[1][1].setState(3);
            break;
        case 5:
            box11.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[1][1].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb12.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][2] = randomColor;
        } else {
            randomColor = colors[1][2];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[1][2].setQuantity(0);
            //                lb12.setText("empty");
            //                wvalue12.setText("0");
            box12.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[1][2].setName(Farming.getState(0));
            Farming.farm.crops[1][2].setState(0);
            break;
        case 2:
            box12.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[1][1].setState(1);
            break;
        case 3:
            box12.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[1][1].setState(2);
            break;
        case 4:
            box12.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[1][1].setState(3);
            break;
        case 5:
            box12.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[1][2].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb13.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[1][3] = randomColor;
        } else {
            randomColor = colors[1][3];
        }
        switch (randomColor) {
        case 1:
            //                lb13.setText("empty");
            //                wvalue13.setText("0");
            Farming.farm.crops[1][3].setQuantity(0);
            box13.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[1][3].setName(Farming.getState(0));
            Farming.farm.crops[1][3].setState(0);
            break;
        case 2:
            box13.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[1][3].setState(1);
            break;
        case 3:
            box13.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[1][3].setState(2);
            break;
        case 4:
            box13.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[1][3].setState(3);
            break;
        case 5:
            box13.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[1][3].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb20.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][0] = randomColor;
        } else {
            randomColor = colors[2][0];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[2][0].setQuantity(0);
            //                lb20.setText("empty");
            //                wvalue20.setText("0");
            box20.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[2][0].setName(Farming.getState(0));
            Farming.farm.crops[2][0].setState(0);
            break;
        case 2:
            box20.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[2][0].setState(1);
            break;
        case 3:
            box20.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[2][0].setState(2);
            break;
        case 4:
            box20.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[2][0].setState(3);
            break;
        case 5:
            box20.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[2][0].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb21.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][1] = randomColor;
        } else {
            randomColor = colors[2][1];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[2][1].setQuantity(0);
            lb21.setText("empty");
            wvalue21.setText("0");
            box21.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[2][1].setName(Farming.getState(0));
            Farming.farm.crops[2][1].setState(0);
            break;
        case 2:
            box21.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[2][1].setState(1);
            break;
        case 3:
            box21.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[2][1].setState(2);
            break;
        case 4:
            box21.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[2][1].setState(3);
            break;
        case 5:
            box21.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[2][1].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb22.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][2] = randomColor;
        } else {
            randomColor = colors[2][2];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[2][2].setQuantity(0);
            lb22.setText("empty");
            wvalue22.setText("0");
            box22.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[2][2].setName(Farming.getState(0));
            Farming.farm.crops[2][2].setState(0);
            break;
        case 2:
            box22.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[2][2].setState(1);

            break;
        case 3:
            box22.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[2][2].setState(2);

            break;
        case 4:
            box22.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[2][2].setState(3);
            break;
        case 5:
            box22.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[2][2].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb23.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[2][3] = randomColor;
        } else {
            randomColor = colors[2][3];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[2][3].setQuantity(0);
            box23.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[2][3].setName(Farming.getState(0));
            Farming.farm.crops[2][3].setState(0);
            break;
        case 2:
            box23.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[2][3].setState(1);
            break;
        case 3:
            box23.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[2][3].setState(2);
            break;
        case 4:
            box23.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[2][3].setState(3);
            break;
        case 5:
            box23.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[2][3].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb30.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][0] = randomColor;
        } else {
            randomColor = colors[3][0];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[3][0].setQuantity(0);
            box30.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[3][0].setName(Farming.getState(0));
            Farming.farm.crops[3][0].setState(0);
            break;
        case 2:
            box30.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[3][0].setState(1);
            break;
        case 3:
            box30.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[3][0].setState(2);
            break;
        case 4:
            box30.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[3][0].setState(3);
            break;
        case 5:
            box30.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[3][0].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb31.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][1] = randomColor;
        } else {
            randomColor = colors[3][1];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[3][1].setQuantity(0);
            box31.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[3][1].setName(Farming.getState(0));
            Farming.farm.crops[3][1].setState(0);
            break;
        case 2:
            box31.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[3][1].setState(1);
            break;
        case 3:
            box31.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[3][1].setState(2);
            break;
        case 4:
            box31.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[3][1].setState(3);
            break;
        case 5:
            box31.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[3][1].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb32.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][2] = randomColor;
        } else {
            randomColor = colors[3][2];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[3][2].setQuantity(0);
            box32.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[3][2].setName(Farming.getState(0));
            Farming.farm.crops[3][2].setState(0);
            break;
        case 2:
            box32.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[3][2].setState(1);
            break;
        case 3:
            box32.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[3][2].setState(2);
            break;
        case 4:
            box32.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[3][2].setState(3);
            break;
        case 5:
            box32.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[3][2].setState(4);
            break;
        default:
            break;

        }
        if (Farming.isStart()) {
            lb33.setText(Farming.getSelectedSeed());
            randomColor = (int) Math.ceil((4 * Math.random()));
            colors[3][3] = randomColor;
        } else {
            randomColor = colors[3][3];
        }
        switch (randomColor) {
        case 1:
            Farming.farm.crops[3][3].setQuantity(0);
            box33.setFill(javafx.scene.paint.Color.web(emptyField));
            Farming.farm.crops[3][3].setName(Farming.getState(0));
            Farming.farm.crops[3][3].setState(0);
            break;
        case 2:
            box33.setFill(javafx.scene.paint.Color.web(seedField));
            Farming.farm.crops[3][3].setState(1);
            break;
        case 3:
            box33.setFill(javafx.scene.paint.Color.web(immatureField));
            Farming.farm.crops[3][3].setState(2);
            break;
        case 4:
            box33.setFill(javafx.scene.paint.Color.web(matureField));
            Farming.farm.crops[3][3].setState(3);
            break;
        case 5:
            box33.setFill(javafx.scene.paint.Color.web(deadFied));
            Farming.farm.crops[3][3].setState(4);
            break;
        default:
            break;

        }
        Farming.setStart(false);
    }

    // return true if field id mature
    private boolean checkColor(String color) {
        return color.equals(matureField);
    }

    private boolean isEmpty(String color) {
        return color.equals(emptyField);
    }

    boolean isEmpty(Rectangle rec) {
        return (rec.getFill() + "").substring(2, 8).equalsIgnoreCase(emptyField);
    }

    private void setWaterLevel() {
        userWater.setText("User Water: " + userWate + "/" + totalWater);
    }

    void show() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Crop.getState(Farming.farm.crops[i][j].getState()));
            }
            System.out.println("");
        }
    }

    @FXML
    private void date(ActionEvent event) {
        Farming.setDay();
        updateDate();
        if (dayCount == 1) {
            System.out.println(dayCount);
            updateFarmStates();
        } else if (dayCount == 2 && Farming.getDay() % 2 == 0) {
            System.out.println(dayCount);
            updateFarmStates();
        } else if (dayCount == 3 && Farming.getDay() % 3 == 0) {
            System.out.println(dayCount);
            updateFarmStates();
        }

    }

    void updateFarmStates() {
        String c = "";
        Rectangle rec = null;
        Label lb = null;
        ////////////////////////////
        int i = 0, j = 0;
        rec = box00;
        lb = wvalue00;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 0;
        j = 1;
        rec = box01;
        lb = wvalue01;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 0;
        j = 2;
        rec = box02;
        lb = wvalue02;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 0;
        j = 3;
        rec = box03;
        lb = wvalue03;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 1;
        j = 0;
        rec = box10;
        lb = wvalue10;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 1;
        j = 1;
        rec = box11;
        lb = wvalue11;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 1;
        j = 2;
        rec = box12;
        lb = wvalue12;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 1;
        j = 3;
        rec = box13;
        lb = wvalue13;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 2;
        j = 0;
        rec = box20;
        lb = wvalue20;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 2;
        j = 1;
        rec = box21;
        lb = wvalue21;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 2;
        j = 2;
        rec = box22;
        lb = wvalue22;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 2;
        j = 3;
        rec = box23;
        lb = wvalue23;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 3;
        j = 0;
        rec = box30;
        lb = wvalue30;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 3;
        j = 1;
        rec = box31;
        lb = wvalue31;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 3;
        j = 2;
        rec = box32;
        lb = wvalue32;
        changeColor(rec, lb, i, j);
        ////////////////////////////
        i = 3;
        j = 3;
        rec = box33;
        lb = wvalue33;
        changeColor(rec, lb, i, j);

    }

    void changeColor(Rectangle rec, Label lb, int i, int j) {
        String c = getRecColor(rec);
        if (!isDead(c) && !isEmpty(c)) {
            // change each farm state (color)
            rec.setFill(javafx.scene.paint.Color.web(upgradeFarm(c, i, j)));
            // decrease water level by 2
            Farming.farm.crops[i][j].setQuantity(Farming.farm.crops[i][j].getQuantity() - 2);
            killField(rec, i, j, "min");
            setWlevelText(lb, i, j);
            //            colors[i][j] += 1;
        }
    }

    void setWlevelText(Label lb, int i, int j) {
        lb.setText(Farming.farm.crops[i][j].getQuantity() + "");
    }

    String getRecColor(Rectangle rec) {
        return (rec.getFill() + "").substring(2, 8);
    }

    String upgradeFarm(String state, int i, int j) {
        switch (state) {
            case seedField:
                colors[i][j] += 1;
                return immatureField;
            case immatureField:
                colors[i][j] += 1;
                return matureField;
            default:
                return state;

        }
    }

    boolean isDead(String color) {
        return color.equalsIgnoreCase(deadFied);
    }

    boolean isDead(Rectangle rec) {
        return (rec.getFill() + "").substring(2, 8).equalsIgnoreCase(deadFied);
    }

    void updateDate() {
        date.setText("Day " + Farming.getDay());
    }

    void killField(Rectangle rec, int a, int b, String y) {
        if (isDead(rec)) {
            return;
        }
        switch (y) {
            case "min":
                if (Farming.farm.crops[a][b].getQuantity() < 0) {
                    rec.setFill(javafx.scene.paint.Color.web(deadFied));
                    colors[a][b] = 5;
                }
                break;
            case "max":
                if (Farming.farm.crops[a][b].getQuantity() > maxWaterLimit) {
                    rec.setFill(javafx.scene.paint.Color.web(deadFied));
                    colors[a][b] = 5;
                }

        }

    }

    void increaseWaterLevel(int x, int y, Label l) {
        Farming.farm.crops[x][y].setQuantity(Farming.farm.crops[x][y].getQuantity() + 1);
        l.setText(Farming.farm.crops[x][y].getQuantity() + "");
    }

    @FXML
    private void btn00(ActionEvent event) {
        Rectangle rec = box00;
        Label wlevel = wvalue00;
        int x = 0, y = 0;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn01(ActionEvent event) {
        Rectangle rec = box01;
        Label wlevel = wvalue01;
        int x = 0, y = 1;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn02(ActionEvent event) {
        Rectangle rec = box02;
        Label wlevel = wvalue02;
        int x = 0, y = 2;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn03(ActionEvent event) {
        Rectangle rec = box03;
        Label wlevel = wvalue03;
        int x = 0, y = 3;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn10(ActionEvent event) {
        Rectangle rec = box10;
        Label wlevel = wvalue10;
        int x = 1, y = 0;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn11(ActionEvent event) {
        Rectangle rec = box11;
        Label wlevel = wvalue11;
        int x = 1, y = 1;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn12(ActionEvent event) {
        Rectangle rec = box12;
        Label wlevel = wvalue12;
        int x = 1, y = 2;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn13(ActionEvent event) {
        Rectangle rec = box13;
        Label wlevel = wvalue13;
        int x = 1, y = 3;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn20(ActionEvent event) {
        Rectangle rec = box20;
        Label wlevel = wvalue20;
        int x = 2, y = 0;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn21(ActionEvent event) {
        Rectangle rec = box21;
        Label wlevel = wvalue21;
        int x = 2, y = 1;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn22(ActionEvent event) {
        Rectangle rec = box22;
        Label wlevel = wvalue22;
        int x = 2, y = 2;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn23(ActionEvent event) {
        Rectangle rec = box23;
        Label wlevel = wvalue23;
        int x = 2, y = 3;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn30(ActionEvent event) {
        Rectangle rec = box30;
        Label wlevel = wvalue30;
        int x = 3, y = 0;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn31(ActionEvent event) {
        Rectangle rec = box31;
        Label wlevel = wvalue31;
        int x = 3, y = 1;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn32(ActionEvent event) {
        Rectangle rec = box32;
        Label wlevel = wvalue32;
        int x = 3, y = 2;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    @FXML
    private void btn33(ActionEvent event) {
        Rectangle rec = box33;
        Label wlevel = wvalue33;
        int x = 3, y = 3;
        if (isEmpty(rec) || isDead(rec)) {
            return;
        }
        if (userWate < 1) {
            JOptionPane.showMessageDialog(null, "Empty Water!");
            return;
        }
        userWate--;
        setWaterLevel();
        increaseWaterLevel(x, y, wlevel);
        killField(rec, x, y, "max");
    }

    void setLabelText() {
        lb00.setText(Farming.farm.crops[0][0].getName());
        wvalue00.setText(Farming.farm.crops[0][0].getQuantity() + "");
        lb01.setText(Farming.farm.crops[0][1].getName());
        wvalue01.setText(Farming.farm.crops[0][1].getQuantity() + "");
        lb02.setText(Farming.farm.crops[0][2].getName());
        wvalue02.setText(Farming.farm.crops[0][2].getQuantity() + "");
        lb03.setText(Farming.farm.crops[0][3].getName());
        wvalue03.setText(Farming.farm.crops[0][3].getQuantity() + "");
        lb10.setText(Farming.farm.crops[1][0].getName());
        wvalue10.setText(Farming.farm.crops[1][0].getQuantity() + "");
        lb11.setText(Farming.farm.crops[1][1].getName());
        wvalue11.setText(Farming.farm.crops[1][1].getQuantity() + "");
        lb12.setText(Farming.farm.crops[1][2].getName());
        wvalue12.setText(Farming.farm.crops[1][2].getQuantity() + "");
        lb13.setText(Farming.farm.crops[1][3].getName());
        wvalue13.setText(Farming.farm.crops[1][3].getQuantity() + "");
        lb20.setText(Farming.farm.crops[2][0].getName());
        wvalue20.setText(Farming.farm.crops[2][0].getQuantity() + "");
        lb21.setText(Farming.farm.crops[2][1].getName());
        wvalue21.setText(Farming.farm.crops[2][1].getQuantity() + "");
        lb22.setText(Farming.farm.crops[2][2].getName());
        wvalue22.setText(Farming.farm.crops[2][2].getQuantity() + "");
        lb23.setText(Farming.farm.crops[2][3].getName());
        wvalue23.setText(Farming.farm.crops[2][3].getQuantity() + "");
        lb30.setText(Farming.farm.crops[3][0].getName());
        wvalue30.setText(Farming.farm.crops[3][0].getQuantity() + "");
        lb31.setText(Farming.farm.crops[3][1].getName());
        wvalue31.setText(Farming.farm.crops[3][1].getQuantity() + "");
        lb32.setText(Farming.farm.crops[3][2].getName());
        wvalue32.setText(Farming.farm.crops[3][2].getQuantity() + "");
        lb33.setText(Farming.farm.crops[3][3].getName());
        wvalue33.setText(Farming.farm.crops[3][3].getQuantity() + "");

    }

}
