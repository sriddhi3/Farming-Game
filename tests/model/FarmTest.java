package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {
    private Farm farm = new Farm(0, 10);

    /*
    Test that user's water level can be accessed and modified
     */
    @Test
    public void getUserWater() {
        assertEquals(0, farm.getUserWater());
    }

    @Test
    public void setUserWater() {
        farm.setUserWater(5);
        assertEquals(5, farm.getUserWater());
    }

    /*
    Test that there is a maximum amount of water that can be
    accessed and modified
     */
    @Test
    public void getTotalWater() {
        assertEquals(10, farm.getTotalWater());
    }

    @Test
    public void setTotalWater() {
        farm.setTotalWater(15);
        assertEquals(15, farm.getTotalWater());
    }
}