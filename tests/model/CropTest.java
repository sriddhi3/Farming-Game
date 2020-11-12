package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CropTest {
    private Crop crop = new Crop("test crop", 10, 100);

    @Test
    public void getName() {
        assertEquals("test crop", crop.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(10, crop.getPrice());
    }

    @Test
    public void getQuantity() {
        assertEquals(100, crop.getQuantity());
    }

    /*
    This tests that plant is alive or dead for m4
     */
    private Crop aliveCrop = new Crop("test crop 2", 10, 100, "alive");

    // test that the plot is empty if there is no crop
    @Test
    public void testAliveCropEmpty() {
        assertEquals("empty", aliveCrop.getState(0));
    }

    private int state1 = 1;
    @Test
    public void testSeed() {
        aliveCrop.setState(state1);
        assertEquals("seed", aliveCrop.getState(1));
    }

    private int state2 = 2;
    @Test
    public void testImmature() {
        aliveCrop.setState(state2);
        assertEquals("immature", aliveCrop.getState(2));
    }

    private int state3 = 3;
    @Test
    public void testMature() {
        aliveCrop.setState(state3);
        assertEquals("mature", aliveCrop.getState(3));
    }

    private int state4 = 4;
    @Test
    public void testDead() {
        aliveCrop.setState(state4);
        assertEquals("dead", aliveCrop.getState(4));
    }

    /*
    Can the player check to see if the plant is fertilized or not?
     */
    private Crop fertilizedCrop = new Crop("test crop fertilized", 10, 10);

    @Test
    public void testNotFertilized() {
        assertEquals(false, fertilizedCrop.isFertilized());
    }

    @Test
    public void checkFertilized() {
        fertilizedCrop.setFertilized(true);
        assertEquals(true, fertilizedCrop.isFertilized());
    }

    /*
    Fertilizer will run out as you use it. Check level
     */

    @Test
    public void fertilizeAmount() {
        fertilizedCrop.setFertilizerLevel(3);
        System.out.println(fertilizedCrop.getFertilizerLevel());
        assertEquals(3, fertilizedCrop.getFertilizerLevel());
    }

    @Test
    public void fertilizeDecrease() {
        fertilizedCrop.setFertilizerLevel(3);

        fertilizedCrop.decFertilizeLevel();
        assertEquals(2, fertilizedCrop.getFertilizerLevel());
        fertilizedCrop.decFertilizeLevel();
        assertEquals(1, fertilizedCrop.getFertilizerLevel());
        fertilizedCrop.decFertilizeLevel();
        assertEquals(0, fertilizedCrop.getFertilizerLevel());
    }

    /*
    Test pesticide on the crop
     */
    private Crop pesticideCrop = new Crop("test crop pesticide", 10, 10);

    @Test
    public void notPesticide() {
        assertEquals(false, pesticideCrop.isPastiside());
    }

    @Test
    public void hasPesticide() {
        pesticideCrop.setPastiside(true);
        assertEquals(true, pesticideCrop.isPastiside());
    }

    /*
    Test pricing of crop. Pesticide should have 10 lower money than non pesticide
     */
    @Test
    public void testPesticidePrice() {
        assertEquals(0, Crop.getCropPrice("Potato", false));
        assertEquals(-10, Crop.getCropPrice("Potato", true));
        int priceNoPesticide = Crop.getCropPrice("Potato", false);
        int priceWithPesticide = Crop.getCropPrice("Potato", true);
        assertTrue(priceNoPesticide > priceWithPesticide);
    }
}