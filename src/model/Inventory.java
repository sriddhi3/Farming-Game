package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    public static ObservableList<Seed> seeds;
    public static ObservableList<Crop> crops;
    public static ObservableList<Item> items;
    private static int capacity;
    private static int total;
    private static String seedToFarm = "";
    private static int qty; // quantity of the seed

    public Inventory() {
        seeds = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
    }

    public static int getQty() {
        return qty;
    }

    public static void setQty(int qty) {
        Inventory.qty = qty;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static String getSeedToFarm() {
        return seedToFarm;
    }

    public static void setSeedToFarm(String seedToFarm) {
        Inventory.seedToFarm = seedToFarm;
    }

    public static void setCapacity(int aCapacity) {
        capacity = aCapacity;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int aTotal) {
        total = aTotal;
    }

    public static void decreaseSeedQty(String seedName) {
        crops.forEach(crop -> {
            if (crop.getName().equalsIgnoreCase(seedName)) {
                crop.setQuantity(crop.getQuantity() - 1);
            }
        });
    }
    public static void addCrop(Crop crop){
        crops.add(crop);
    }

}
