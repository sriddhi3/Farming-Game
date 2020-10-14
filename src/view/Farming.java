package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Inventory;
import model.Item;
import model.Seed;

public class Farming extends Application {

    private static String selectedDifficulty;
    private static String selectedSeed;
    private static String selectedSeason;
    private static int totalMoney = 100;
    private static Inventory inventory = new Inventory();
    private static boolean start = true;
    public static int[][] colors = new int[4][4];
    private static int pricingFactor;
    final private static int TAX = 2;
    private static int price;
    private static boolean inventoryCheck = true;
    private static boolean inventoryCheck2 = true;
    private static boolean marketCheck = true;
    private static String playerName;
    public static ObservableList<Item> items = FXCollections.observableArrayList();
    public static ObservableList<Seed> seed = FXCollections.observableArrayList();
    public static void main(String[] args) {
        launch(args);
    }

    public static String getSelectedSeason() {
        return selectedSeason;
    }

    public static void setSelectedSeason(String aSelectedSeason) {
        selectedSeason = aSelectedSeason;
    }

    public static int getTotalMoney() {
        return totalMoney;
    }

    public static void setTotalMoney(int aTotalMoney) {
        totalMoney = aTotalMoney;
    }

    public static Inventory getInventory() {
        return inventory;
    }

    public static void setInventory(Inventory aInventory) {
        inventory = aInventory;
    }

    public static boolean isStart() {
        return start;
    }

    public static void setStart(boolean aStart) {
        start = aStart;
    }

    public static int getPricingFactor() {
        return pricingFactor;
    }

    public static void setPricingFactor(int aPricingFactor) {
        pricingFactor = aPricingFactor;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int aPrice) {
        price = aPrice;
    }

    public static boolean isInventoryCheck() {
        return inventoryCheck;
    }

    public static void setInventoryCheck(boolean aInventoryCheck) {
        inventoryCheck = aInventoryCheck;
    }

    public static boolean isInventoryCheck2() {
        return inventoryCheck2;
    }

    public static void setInventoryCheck2(boolean aInventoryCheck2) {
        inventoryCheck2 = aInventoryCheck2;
    }

    public static boolean isMarketCheck() {
        return marketCheck;
    }

    public static void setMarketCheck(boolean aMarketCheck) {
        marketCheck = aMarketCheck;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String aPlayerName) {
        playerName = aPlayerName;
    }

    public static String getSelectedDifficulty() {
        return selectedDifficulty;
    }

    public static void setSelectedDifficulty(String aSelectedDifficulty) {
        selectedDifficulty = aSelectedDifficulty;
    }

    public static String getSelectedSeed() {
        return selectedSeed;
    }

    public static void setSelectedSeed(String aSelectedSeed) {
        selectedSeed = aSelectedSeed;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome_screen.fxml"));
        primaryStage.setTitle("Farming Game");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }

    
    public static void fillItems() {
        items.addAll(new Item("Compost", pricingFactor * (5 + TAX)),
                new Item("Sickle", pricingFactor * (10 + TAX)),
                new Item("Scare Crow", pricingFactor * (300 + TAX)),
                new Item("Wagon", pricingFactor * (500 + TAX)),
                new Item("Fence", pricingFactor * (50 + TAX)));
        seed.addAll(new Seed(pricingFactor * (4 + TAX), "Potato"),
                new Seed(pricingFactor * (5 + TAX), "Onion"),
                new Seed(pricingFactor * (7 + TAX), "Cabbage"),
                new Seed(pricingFactor * (2 + TAX), "Wheat"),
                new Seed(pricingFactor * (3 + TAX), "Corn"),
                new Seed(pricingFactor * (2 + TAX), "Rice"));
    }
}
