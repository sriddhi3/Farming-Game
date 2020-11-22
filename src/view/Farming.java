package view;

import model.Crop;
import model.Farm;
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
import javax.swing.JOptionPane;

public class Farming extends Application {

    private static String selectedDifficulty;
    private static String selectedSeed;
    private static String selectedSeason;
    private static int price;
    private static String playerName;
    private static int wellCapacity;
    private static int maxWaterLvel;
    private static int pricingFactor;
    private static boolean pestiside;
    private static int dayCount;
    private static int fPrice;
    private static int hireDays;
    private static boolean mature;
    private static boolean hired;
    private static int tractorPrice;
    private static int harvestCount;
    private static int waterCount;
    private static boolean tractorBuy;
    private static boolean irragation;
    private static int irrigationPrice;
    private static boolean first;
    private static boolean inventoryCheck = true;
    private static boolean inventoryCheck2 = true;
    private static boolean marketCheck = true;
    private static boolean start = true;
    private static boolean iuiCheck = true;    // Initail UI check
    private static int day = 0;
    private static int totalMoney = 100;
    private final static int tax = 2;
    public static ObservableList<Item> items = FXCollections.observableArrayList();
    public static ObservableList<Seed> seed = FXCollections.observableArrayList();
    public static int[][] colors = new int[4][4];
    public static Farm farm = new Farm(0, 0);
    private static final String[] states = {"empty", "seed", "immature", "mature", "dead"};
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
//        farm.crops[0][0] = new Crop();
        setFirst(true);
        initFarm();
        launch(args);
    }

    public static boolean isFirst() {
        return first;
    }

    public static void setFirst(boolean first) {
        Farming.first = first;
    }

    public static boolean isIrragation() {
        return irragation;
    }

    public static void setIrragation(boolean irragation) {
        Farming.irragation = irragation;
    }

    public static int getIrrigationPrice() {
        return irrigationPrice;
    }

    public static void setIrrigationPrice(int irrigationPrice) {
        Farming.irrigationPrice = irrigationPrice;
    }

    public static int getHireDays() {
        return hireDays;
    }

    public static void setHireDays(int hireDays) {
        Farming.hireDays = hireDays;
    }

    public static boolean isMature() {
        return mature;
    }

    public static void setMature(boolean mature) {
        Farming.mature = mature;
    }

    public static boolean isHired() {
        return hired;
    }

    public static void setHired(boolean hired) {
        Farming.hired = hired;
    }

    public static int getTractorPrice() {
        return tractorPrice;
    }

    public static void setTractorPrice(int tractorPrice) {
        Farming.tractorPrice = tractorPrice;
    }

    private static void initFarm() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                farm.crops[i][j] = new Crop();
            }
        }
    }

    public static int getHarvestCount() {
        return harvestCount;
    }

    public static void setHarvestCount(int harvestCount) {
        Farming.harvestCount = harvestCount;
    }

    public static void incHarvestCount() {
        harvestCount++;
    }

    public static int getWaterCount() {
        return waterCount;
    }

    public static void setWaterCount(int waterCount) {
        Farming.waterCount = waterCount;
    }

    public static void incWaterCount() {
        waterCount++;
    }

    public static int getfPrice() {
        return fPrice;
    }

    public static void setfPrice(int fPrice) {
        Farming.fPrice = fPrice;
    }

    public static boolean isPestiside() {
        return pestiside;
    }

    public static void setPestiside(boolean pestiside) {
        Farming.pestiside = pestiside;
    }

    public static int getDayCount() {
        return dayCount;
    }

    public static void setDayCount(int dayCount) {
        Farming.dayCount = dayCount;
    }

    public static int getMaxWaterLvel() {
        return maxWaterLvel;
    }

    public static void setMaxWaterLvel(int maxWaterLvel) {
        Farming.maxWaterLvel = maxWaterLvel;
    }

    public static String getState(int index) {
        return states[index];
    }

    public static boolean isIuiCheck() {
        return iuiCheck;
    }

    public static void setIuiCheck(boolean iuiCheck) {
        Farming.iuiCheck = iuiCheck;
    }

    public static int getDay() {
        return day;
    }

    public static void setDay() {
        Farming.day += 1;
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

    public static boolean getInventoryCheck() {
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

    public static int getWellCapacity() {
        return wellCapacity;
    }

    public static void setWellCapacity(int aWellCapacity) {
        wellCapacity = aWellCapacity;
    }

    public static boolean isTractorBuy() {
        return tractorBuy;
    }

    public static void setTractorBuy(boolean aTractorBuy) {
        tractorBuy = aTractorBuy;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome_screen.fxml"));
        primaryStage.setTitle("Farming Game");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }

    public static int getTax() {
        return tax;
    }

    public static void fillItems() {
        items.addAll(new Item("Compost", pricingFactor * (5 + tax)), new Item("Sickle", pricingFactor * (10 + tax)), new Item("Scare Crow", pricingFactor * (300 + tax)), new Item("Wagon", pricingFactor * (500 + tax)), new Item("Fence", pricingFactor * (50 + tax)));
        seed.addAll(new Seed(pricingFactor * (4 + tax), "Potato"), new Seed(pricingFactor * (5 + tax), "Onion"), new Seed(pricingFactor * (7 + tax), "Cabbage"), new Seed(pricingFactor * (2 + tax), "Wheat"), new Seed(pricingFactor * (3 + tax), "Corn"), new Seed(pricingFactor * (2 + tax), "Rice"));
    }

    public static void decTotalMoney(int amount) {
        setTotalMoney(getTotalMoney() - amount);
    }

    public static void incTotalMoney(int amount) {
        setTotalMoney(getTotalMoney() + amount);
    }

}
