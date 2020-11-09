
package Model;

public class Farm {
    public Crop[][] crops;
    private int userWater;
    private int totalWater;

    public Farm(int userWater, int totalWater) {
        this.userWater = userWater;
        this.totalWater = totalWater;
        crops = new Crop[4][4];
    }

    public int getUserWater() {
        return userWater;
    }

    public void setUserWater(int userWater) {
        this.userWater = userWater;
    }

    public int getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(int totalWater) {
        this.totalWater = totalWater;
    }
 
}
