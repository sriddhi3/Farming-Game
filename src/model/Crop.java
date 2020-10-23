package model;

public class Crop {

    private String name;
    private int price;
    private int quantity;
    private int state;
    private int maxWater;
    private String type;
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

}
