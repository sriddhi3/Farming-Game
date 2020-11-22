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
    private static int fertilize;

    public Inventory() {
        seeds = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
    }

    public static ObservableList<Seed> getSeeds() {
        return seeds;
    }

    public static void setSeeds(ObservableList<Seed> seeds) {
        Inventory.seeds = seeds;
    }

    public static ObservableList<Crop> getCrops() {
        return crops;
    }

    public static void setCrops(ObservableList<Crop> crops) {
        Inventory.crops = crops;
    }

    public static ObservableList<Item> getItems() {
        return items;
    }

    public static void setItems(ObservableList<Item> items) {
        Inventory.items = items;
    }

    public static int getFertilize() {
        return fertilize;
    }

    public static void setFertilize(int fertilize) {
        Inventory.fertilize = fertilize;
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

    public static void addCrop(Crop crop) {
        crops.add(crop);
    }
    
    public static void incFertilze(){
        fertilize++;
    }
    
    public static void decFertelize(){
        if(fertilize < 1){
            return;
        }
        fertilize--;
    }

}
