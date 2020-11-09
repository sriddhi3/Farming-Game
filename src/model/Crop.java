package Model;

import static View.Farming.getPricingFactor;
import static View.Farming.getTax;

public class Crop {

    private String name;
    private int price;
    private int quantity;
    private int state;
    private int maxWater;
    private String type;
    private boolean pastiside;
    private int fertilizerLevel;
    private boolean fertilized;

    public Crop(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.state = 0;

    }

    public Crop(String name, int price, int quantity, String type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.state = 0;
        this.type = type;

    }

    public Crop() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.state = 0;
    }

    public Crop(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Crop(String name) {
        this.name = name;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

    public void setFertilizerLevel(int fertilizerLevel) {
        this.fertilizerLevel = fertilizerLevel;
    }

    public boolean isFertilized() {
        return fertilized;
    }

    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }

    
    public boolean isPastiside() {
        return pastiside;
    }

    public void setPastiside(boolean pastiside) {
        this.pastiside = pastiside;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxWater() {
        return maxWater;
    }

    public void setMaxWater(int maxWater) {
        this.maxWater = maxWater;
    }

    public String getName() {
        return name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static String getState(int index) {
        switch (index) {
            case 0:
                return "empty";
            case 1:
                return "seed";
            case 2:
                return "immature";
            case 3:
                return "mature";
            case 4:
                return "dead";
            default:
                return null;
        }
    }

    public static int getCropPrice(String cropName, boolean pastcide) {
        System.out.println("///" + cropName + "///");
        int price = 0;
        switch (cropName) {
            case "Potato":
                price = 4;
                break;
            case "potato":
                price = 4;
                break;
            case "Onion":
                price = 5;
                break;
            case "onion":
                price = 5;
                break;
            case "Cabbage":
                price = 7;
                break;
            case "Wheat":
                price = 2;
                break;
            case "wheat":
                price = 2;
                break;
            case "Corn":
                price = 3;
                break;
            case "corn":
                price = 3;
                break;
            case "Rice":
                price = 2;
                break;
            case "rice":
                price = 2;
                break;
            default:
                System.out.println("Something Wrong With Getting Price");
        }
        if (pastcide) {
            return getPricingFactor() * (price + getTax()) - 10;
        }
        return getPricingFactor() * (price + getTax());
    }

    public void decFertilizeLevel(){
        if(fertilizerLevel < 1){
            return;
        }
        fertilizerLevel--;
    }
}
