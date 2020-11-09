package View;

import org.junit.Test;

import static org.junit.Assert.*;

public class FarmingTest {
    private Farming farming = new Farming();

    @Test
    public void testFarmObject() {
        assertNotNull(farming);
    }

    /*
    Set up max water level
     */
    @Test
    public void setMaxWaterLevelTest () {
        farming.setMaxWaterLvel(10);
        assertEquals(10, farming.getMaxWaterLvel());
    }

    /*
    Test initial water level is 0
     */
    @Test
    public void testInitialWater() {
        assertEquals(0, farming.getMaxWaterLvel());
    }

    /*
    This test ensure that the day is incremented by 1
     */
    @Test
    public void testDayIncrement() {
        int currentDay = farming.getDay(); // get current day
        farming.setDay(); // day is incremented by 1
        // check increment
        System.out.println(currentDay);
        System.out.println(farming.getDay());
        assertEquals(currentDay + 1, farming.getDay());
    }
}