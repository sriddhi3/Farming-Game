package View;

import static Model.Inventory.crops;
import static View.Farming.isPestiside;
import static View.Farming.setPestiside;
import static Model.Crop.getCropPrice;
import static View.Farming.getTotalMoney;
import static View.Farming.setTotalMoney;
import static View.Farming.getSelectedDifficulty;
import static Model.Inventory.getFertilize;
import static Model.Inventory.decFertelize;
import static View.Farming.farm;
import Model.Crop;
import Model.Inventory;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
//    Rectangle[] boxes = {box00, box01, box02, box03, box10, box11, box12, box13, box20, box21, box22, box23, box30, box31, box32, box33};
    @FXML
    private Button pestiside;
    @FXML
    private Label pstid;
    @FXML
    private Label f00;
    @FXML
    private Label f01;
    @FXML
    private Label f02;
    @FXML
    private Label f03;
    @FXML
    private Label f10;
    @FXML
    private Label f11;
    @FXML
    private Label f12;
    @FXML
    private Label f13;
    @FXML
    private Label f20;
    @FXML
    private Label f21;
    @FXML
    private Label f22;
    @FXML
    private Label f23;
    @FXML
    private Label f30;
    @FXML
    private Label f31;
    @FXML
    private Label f32;
    @FXML
    private Label f33;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        season.setText("Season: " + Farming.getSelectedSeason());
        money.setText("Money: " + getTotalMoney());
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
        boxAction(rec, lb, wv, i, j, f00);

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
        boxAction(rec, lb, wv, i, j, f01);
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
        boxAction(rec, lb, wv, i, j, f02);
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
        boxAction(rec, lb, wv, i, j, f03);
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
        boxAction(rec, lb, wv, i, j, f10);
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
        boxAction(rec, lb, wv, i, j, f11);
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
        boxAction(rec, lb, wv, i, j, f12);
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
        boxAction(rec, lb, wv, i, j, f13);
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
        boxAction(rec, lb, wv, i, j, f20);
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
        boxAction(rec, lb, wv, i, j, f21);
    }

    @FXML
    private void box22Clicked(MouseEvent event) {
        if (Inventory.getCapacity() <= 0) {
            JOptionPane.showMessageDialog(null, "Not enough capacity");
            return;
        }
        Rectangle rec = box22;
        Label lb = lb22;
        Label wv = wvalue22;
        int i = 2;
        int j = 2;
        boxAction(rec, lb, wv, i, j, f22);
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
        boxAction(rec, lb, wv, i, j, f23);
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
        boxAction(rec, lb, wv, i, j, f30);
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
        boxAction(rec, lb, wv, i, j, f31);
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
        boxAction(rec, lb, wv, i, j, f32);
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
        boxAction(rec, lb, wv, i, j, f33);
    }

    void updateMoneyLabel() {
        money.setText("Money: " + getTotalMoney());
    }

    void boxAction(Rectangle rec, Label lb, Label wv, int i, int j, Label f) {
        System.out.println(lb.getText() + "   asdgadfb");
        System.out.println("BOX ACRION");
        String c = (rec.getFill() + "").substring(2, 8);
        if (isPestiside()) {
            if (!isDead(rec)) {
                if (!Farming.farm.crops[i][j].isPastiside()) {
                    switch (getSelectedDifficulty()) {
                        case "easy":
                            setTotalMoney(getTotalMoney() - 10);
                            break;
                        case "medium":
                            setTotalMoney(getTotalMoney() - 20);
                            break;
                        case "hard":
                            setTotalMoney(getTotalMoney() - 30);
                            break;
                        default:
                            System.out.println("Something Wrong with pasticide");
                    }
                    updateMoneyLabel();
                    Farming.farm.crops[i][j].setPastiside(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Pasticide Alreasy Applied");
                }
            }
//            System.out.println(getTotalMoney());
            return;
        }
        /////////////// if farm is mature or no dead
        if (checkColor(c) || isDead(rec)) {

            updateFertileLevels(i, j, f);
            if (!isDead(rec)) {
                Farming.farm.crops[i][j].setPastiside(false);
                addCropToInventory(i, j, lb.getText());
                Inventory.setCapacity(Inventory.getCapacity() - 1);
            }
            wv.setText("0");
            lb.setText("empty");
//            if (!isDead(rec)) {
//                Inventory.setCapacity(Inventory.getCapacity() - 1);
//            }
            rec.setFill(javafx.scene.paint.Color.web(emptyField));

            colors[i][j] = 1;
            return;
        }
        /////////////// Farm new Seed
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
    }

    private void updateFertileLevels(int i, int j, Label f) {
        Farming.farm.crops[i][j].decFertilizeLevel();
        f.setText(Farming.farm.crops[i][j].getFertilizerLevel() + "");
    }

    void incCapacity() {
        Inventory.setCapacity(Inventory.getCapacity() + 1);
    }

    void decCapacity() {
        Inventory.setCapacity(Inventory.getCapacity() - 1);
    }

    void addCropToInventory(int i, int j, String cropName) {
        for (Crop x : crops) {
            if (x.getName().equalsIgnoreCase(cropName)) {
                if (Farming.farm.crops[i][j].getFertilizerLevel() > 0) {
                    x.setQuantity(x.getQuantity() + 2);
                } else {
                    x.setQuantity(x.getQuantity() + 1);
                }
                return;
            }
        }
        if (Farming.farm.crops[i][j].isPastiside()) {
            crops.add(new Crop(cropName, getCropPrice(cropName, true), 1, "Crop"));
        }
        crops.add(new Crop(cropName, getCropPrice(cropName, false), 1, "Crop"));

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

    private int getEvent() {
//        Random r = new Random();
        switch (getSelectedDifficulty()) {
            case "easy":
                return (int) Math.ceil(Math.random() * 10);
            case "medium":
                return (int) Math.ceil(Math.random() * 8);
            case "hard":
                return (int) Math.ceil(Math.random() * 5);
            default:
                return -1;
        }
    }

    private int getRandomNum(int r) {    // returns between 1 - r
//        Random r = new Random();
        return (int) Math.ceil(Math.random() * r);
    }

    void eventX(int flag) {
        int waterInc = getRandomNum(3);
        if (flag == 0) {
            JOptionPane.showMessageDialog(null, "There is heavy rainfall today! Water levels have increased by " + waterInc);
            waterThings(waterInc, 1);
        } else if (flag == 1) {
            JOptionPane.showMessageDialog(null, "There is a drought today! Water levels have decreased by " + waterInc);
            waterThings(waterInc, 0);
        }
    }

    void waterThings(int level, int flag) {
        //// Increase Water level and update water value label
        increaseWaterLevel(0, 0, wvalue00, level, flag);
        increaseWaterLevel(0, 1, wvalue01, level, flag);
        increaseWaterLevel(0, 2, wvalue02, level, flag);
        increaseWaterLevel(0, 3, wvalue03, level, flag);

        increaseWaterLevel(1, 0, wvalue10, level, flag);
        increaseWaterLevel(1, 1, wvalue11, level, flag);
        increaseWaterLevel(1, 2, wvalue12, level, flag);
        increaseWaterLevel(1, 3, wvalue13, level, flag);

        increaseWaterLevel(2, 0, wvalue20, level, flag);
        increaseWaterLevel(2, 1, wvalue21, level, flag);
        increaseWaterLevel(2, 2, wvalue22, level, flag);
        increaseWaterLevel(2, 3, wvalue23, level, flag);

        increaseWaterLevel(3, 0, wvalue30, level, flag);
        increaseWaterLevel(3, 1, wvalue31, level, flag);
        increaseWaterLevel(3, 2, wvalue32, level, flag);
        increaseWaterLevel(3, 3, wvalue33, level, flag);
        //////// Kill fieald if water level exceeds
        killField(box00, 0, 0, "min");
        killField(box01, 0, 1, "min");
        killField(box02, 0, 2, "min");
        killField(box03, 0, 3, "min");

        killField(box10, 1, 0, "min");
        killField(box11, 1, 1, "min");
        killField(box12, 1, 2, "min");
        killField(box13, 1, 3, "min");

        killField(box20, 2, 0, "min");
        killField(box21, 2, 1, "min");
        killField(box22, 2, 2, "min");
        killField(box23, 2, 3, "min");

        killField(box30, 3, 0, "min");
        killField(box31, 3, 1, "min");
        killField(box32, 3, 2, "min");
        killField(box33, 3, 3, "min");
    }

    void increaseWaterLevel(int x, int y, Label l, int level, int flag) {
        if (Integer.parseInt(l.getText()) != 0 && flag == 1) {
            Farming.farm.crops[x][y].setQuantity(Farming.farm.crops[x][y].getQuantity() + level);
            l.setText(Farming.farm.crops[x][y].getQuantity() + "");
        } else if (Integer.parseInt(l.getText()) != 0 && flag == 0) {
            Farming.farm.crops[x][y].setQuantity(Farming.farm.crops[x][y].getQuantity() - level);
            l.setText(Farming.farm.crops[x][y].getQuantity() + "");
        }

    }

    private void locusts() {
        int effacted = 0;
        if (getSelectedDifficulty().endsWith("easy")) {
            effacted = 2;
        } else if (getSelectedDifficulty().endsWith("medium")) {
            effacted = 4;
        } else if (getSelectedDifficulty().endsWith("hard")) {
            effacted = 6;
        }
        JOptionPane.showMessageDialog(null, "There is a drought today! Water levels have decreased by " + effacted);
        int count = 0;
        for (int i = 0; i < effacted;) {
            while (true) {
                int num = (int) Math.floor(Math.random() * 16);
                boolean x = attack(num);
                System.out.println(x + "\t" + num);
                if (x) {
                    i++;
                    break;
                }
            }
        }
    }

    private boolean killedByAttack(Rectangle rec, int i, int j, String filler) {
        if (isDead(rec) || isEmpty(rec) || Farming.farm.crops[i][j].isPastiside()) {
            return false;
        }
        rec.setFill(javafx.scene.paint.Color.web(deadFied));
        colors[i][j] = 5;
        return true;
    }

    private boolean attack(int n) {
        switch (n) {
            case 0:
                return killedByAttack(box00, 0, 0, "min");
            case 1:
                if (Farming.farm.crops[0][1].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box01, 0, 1, "min");
            case 2:
                if (Farming.farm.crops[0][2].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box02, 0, 2, "min");
            case 3:
                if (Farming.farm.crops[0][3].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box03, 0, 3, "min");
            case 4:
                if (Farming.farm.crops[1][0].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box10, 1, 0, "min");
            case 5:
                if (Farming.farm.crops[1][1].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box11, 1, 1, "min");
            case 6:
                if (Farming.farm.crops[1][2].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box12, 1, 2, "min");
            case 7:
                if (Farming.farm.crops[1][3].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box13, 1, 3, "min");
            case 8:
                if (Farming.farm.crops[2][0].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box20, 2, 0, "min");
            case 9:
                if (Farming.farm.crops[2][1].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box21, 2, 1, "min");
            case 10:
                if (Farming.farm.crops[2][2].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box22, 2, 2, "min");
            case 11:
                if (Farming.farm.crops[2][3].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box23, 2, 3, "min");
            case 12:
                if (Farming.farm.crops[3][0].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box30, 3, 0, "min");
            case 13:
                if (Farming.farm.crops[3][1].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box31, 3, 1, "min");
            case 14:
                if (Farming.farm.crops[3][2].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box32, 3, 2, "min");
            case 15:
                if (Farming.farm.crops[3][3].isPastiside()) {
                    System.out.println("Pasticide");
                    return false;
                }
                return killedByAttack(box33, 3, 3, "min");
            default:
                System.out.println("Wrong with attack");
                return false;
        }
    }

    @FXML
    private void date(ActionEvent event) {
        updateFertileLevels();
        int r = getEvent();     // Probablity of occuring event
//        r = 3;
        if (r == 3) {
//            System.out.println(r);
//            int e = 3;
            int e = getRandomNum(3);       // Getting random event
            switch (e) {
                case 1:
                    eventX(0);  // Rain event
                    return;
                case 2:
                    eventX(1);  // Drought Event
                    return;
                case 3:
                    locusts();
                    return;
                default:
                    System.out.println("Wrong with getting event");
            }

        }
        Farming.setDay();
        updateDate();
        if (dayCount == 1) {
            updateFarmStates();
        } else if (dayCount == 2 && Farming.getDay() % 2 == 0) {
            updateFarmStates();
        } else if (dayCount == 3 && Farming.getDay() % 3 == 0) {
            updateFarmStates();
        }

    }

    private void updateFertileLevels() {
        for (int i = 0; i < Farming.farm.crops.length; i++) {
            for (int j = 0; j < Farming.farm.crops.length; j++) {
                Farming.farm.crops[i][j].decFertilizeLevel();
            }
        }
        setLabelText();
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
                if(Farming.farm.crops[i][j].getFertilizerLevel() > 0){
                    colors[i][j] += 1;
                    return matureField;
                }
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

    boolean killField(Rectangle rec, int a, int b, String y) {

        if (isDead(rec) || isEmpty(rec)) {
            return false;
        }
        if (Farming.farm.crops[a][b].getQuantity() < 0 || Farming.farm.crops[a][b].getQuantity() > maxWaterLimit) {
            rec.setFill(javafx.scene.paint.Color.web(deadFied));
            colors[a][b] = 5;
            return true;
        }
        return false;

    }

    void increaseWaterLevel(int x, int y, Label l, int level) {
        if (Integer.parseInt(l.getText()) != 0) {
            Farming.farm.crops[x][y].setQuantity(Farming.farm.crops[x][y].getQuantity() + level);
            l.setText(Farming.farm.crops[x][y].getQuantity() + "");
        }

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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
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
        increaseWaterLevel(x, y, wlevel, 1);
        killField(rec, x, y, "max");
    }

    void setLabelText() {
        ////////////////0-0 ////////////
        lb00.setText(Farming.farm.crops[0][0].getName());
        wvalue00.setText(Farming.farm.crops[0][0].getQuantity() + "");
        f00.setText(Farming.farm.crops[0][0].getFertilizerLevel() + "");
        ////////////////0-1 ////////////
        lb01.setText(Farming.farm.crops[0][1].getName());
        wvalue01.setText(Farming.farm.crops[0][1].getQuantity() + "");
        f01.setText(Farming.farm.crops[0][1].getFertilizerLevel() + "");
        ////////////////0-2 ////////////
        lb02.setText(Farming.farm.crops[0][2].getName());
        wvalue02.setText(Farming.farm.crops[0][2].getQuantity() + "");
        f02.setText(Farming.farm.crops[0][2].getFertilizerLevel() + "");
        ////////////////0-3 ////////////
        lb03.setText(Farming.farm.crops[0][3].getName());
        wvalue03.setText(Farming.farm.crops[0][3].getQuantity() + "");
        f03.setText(Farming.farm.crops[0][3].getFertilizerLevel() + "");
        ////////////////1-0 ////////////
        lb10.setText(Farming.farm.crops[1][0].getName());
        wvalue10.setText(Farming.farm.crops[1][0].getQuantity() + "");
        f10.setText(Farming.farm.crops[1][0].getFertilizerLevel() + "");
        ////////////////1-1 ////////////
        lb11.setText(Farming.farm.crops[1][1].getName());
        wvalue11.setText(Farming.farm.crops[1][1].getQuantity() + "");
        f11.setText(Farming.farm.crops[1][1].getFertilizerLevel() + "");
        ////////////////1-2 ////////////
        lb12.setText(Farming.farm.crops[1][2].getName());
        wvalue12.setText(Farming.farm.crops[1][2].getQuantity() + "");
        f12.setText(Farming.farm.crops[1][2].getFertilizerLevel() + "");
        ////////////////1-3 ////////////
        lb13.setText(Farming.farm.crops[1][3].getName());
        wvalue13.setText(Farming.farm.crops[1][3].getQuantity() + "");
        f13.setText(Farming.farm.crops[1][3].getFertilizerLevel() + "");
        ////////////////2-0 ////////////
        lb20.setText(Farming.farm.crops[2][0].getName());
        wvalue20.setText(Farming.farm.crops[2][0].getQuantity() + "");
        f20.setText(Farming.farm.crops[2][0].getFertilizerLevel() + "");
        ////////////////2-1 ////////////
        lb21.setText(Farming.farm.crops[2][1].getName());
        wvalue21.setText(Farming.farm.crops[2][1].getQuantity() + "");
        f21.setText(Farming.farm.crops[2][1].getFertilizerLevel() + "");
        ////////////////2-2 ////////////
        lb22.setText(Farming.farm.crops[2][2].getName());
        wvalue22.setText(Farming.farm.crops[2][2].getQuantity() + "");
        f22.setText(Farming.farm.crops[2][2].getFertilizerLevel() + "");
        ////////////////2-3 ////////////
        lb23.setText(Farming.farm.crops[2][3].getName());
        wvalue23.setText(Farming.farm.crops[2][3].getQuantity() + "");
        f23.setText(Farming.farm.crops[2][3].getFertilizerLevel() + "");
        ////////////////3-0 ////////////
        lb30.setText(Farming.farm.crops[3][0].getName());
        wvalue30.setText(Farming.farm.crops[3][0].getQuantity() + "");
        f30.setText(Farming.farm.crops[3][0].getFertilizerLevel() + "");
        ////////////////3-1 ////////////
        lb31.setText(Farming.farm.crops[3][1].getName());
        wvalue31.setText(Farming.farm.crops[3][1].getQuantity() + "");
        f31.setText(Farming.farm.crops[3][1].getFertilizerLevel() + "");
        ////////////////3-2 ////////////
        lb32.setText(Farming.farm.crops[3][2].getName());
        wvalue32.setText(Farming.farm.crops[3][2].getQuantity() + "");
        f32.setText(Farming.farm.crops[3][2].getFertilizerLevel() + "");
        ////////////////3-3 ////////////
        lb33.setText(Farming.farm.crops[3][3].getName());
        wvalue33.setText(Farming.farm.crops[3][3].getQuantity() + "");
        f33.setText(Farming.farm.crops[3][3].getFertilizerLevel() + "");

    }

    @FXML
    private void pestiside(ActionEvent event) {
        if (isPestiside()) {
            pstid.setText("Deselected");
        } else {
            pstid.setText("Selected");
        }
        setPestiside(!isPestiside());
    }

    private void decreaseFertilizeLevel(int i, int j) {
        if (Inventory.getFertilize() == 0) {
            return;
        }
        farm.crops[i][j].setFertilizerLevel(farm.crops[i][j].getFertilizerLevel() - 1);
        setLabelText();

    }

    private void increaseFertilizeLevel(int i, int j) {
        if (getFertilize() < 1) {
            JOptionPane.showMessageDialog(null, "Not enough fertilizer");
            return;
        }
        decFertelize();
        farm.crops[i][j].setFertilizerLevel(farm.crops[i][j].getFertilizerLevel() + 1);
        setLabelText();

    }

    ////////////////////////////////////Fertilizer Things
    private void fertilize(Label lb, int i, int j) {
        if (farm.crops[i][j].getFertilizerLevel() == 0) {
            return;
        }
    }

    @FXML
    private void f00(ActionEvent event) {
        increaseFertilizeLevel(0, 0);
    }

    @FXML
    private void f01(ActionEvent event) {
        increaseFertilizeLevel(0, 1);
    }

    @FXML
    private void f02(ActionEvent event) {
        increaseFertilizeLevel(0, 2);
    }

    @FXML
    private void f03(ActionEvent event) {
        increaseFertilizeLevel(0, 3);
    }

    @FXML
    private void f10(ActionEvent event) {
        increaseFertilizeLevel(1, 0);
    }

    @FXML
    private void f11(ActionEvent event) {
        increaseFertilizeLevel(1, 1);
    }

    @FXML
    private void f12(ActionEvent event) {
        increaseFertilizeLevel(1, 2);
    }

    @FXML
    private void f13(ActionEvent event) {
        increaseFertilizeLevel(1, 3);
    }

    @FXML
    private void f20(ActionEvent event) {
        increaseFertilizeLevel(2, 0);
    }

    @FXML
    private void f21(ActionEvent event) {
        increaseFertilizeLevel(2, 1);
    }

    @FXML
    private void f22(ActionEvent event) {
        increaseFertilizeLevel(2, 2);
    }

    @FXML
    private void f23(ActionEvent event) {
        increaseFertilizeLevel(2, 3);
    }

    @FXML
    private void f30(ActionEvent event) {
        increaseFertilizeLevel(3, 0);
    }

    @FXML
    private void f31(ActionEvent event) {
        increaseFertilizeLevel(3, 1);
    }

    @FXML
    private void f32(ActionEvent event) {
        increaseFertilizeLevel(3, 2);
    }

    @FXML
    private void f33(ActionEvent event) {
        increaseFertilizeLevel(3, 3);
    }

}
