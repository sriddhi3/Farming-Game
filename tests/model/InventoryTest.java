package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory inventory = new Inventory();

    @Test
    public void testCapacity() {
        assertNotNull(inventory.getCapacity());
    }

    @Test
    public void testTotal() {
        assertNotNull(inventory.getTotal());
    }

    @Test
    public void testObservableLists() {
        assertNotNull(inventory.seeds);
        assertNotNull(inventory.crops);
    }

    /*
    Testing fertilizer amount and level, by adding and using fertilizer
    Buying should increase level
    Using should decrease level
     */
    @Test
    public void testFertilizerInventoryAmount() {
        inventory.setFertilize(3);
        assertEquals(3, inventory.getFertilize());
    }

    @Test
    public void buyFertilizer() {
        inventory.setFertilize(0);
        inventory.incFertilze();
        assertEquals(1, inventory.getFertilize());
        inventory.incFertilze();
        assertEquals(2, inventory.getFertilize());
    }

    @Test
    public void useFertilizer() {
        inventory.setFertilize(2);
        inventory.decFertelize();
        assertEquals(1, inventory.getFertilize());
        inventory.decFertelize();
        assertEquals(0, inventory.getFertilize());
    }
}