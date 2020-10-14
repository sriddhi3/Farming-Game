package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    public static ObservableList<Seed> seeds;
    public static ObservableList<Crop> crops;
    public static ObservableList<Item> items;
    private static int capacity;
    private static int total;

    public static int getCapacity() {
        return capacity;
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

    public Inventory() {
        seeds = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
        crops = FXCollections.observableArrayList();
    }
    
    
    

    
    
}
