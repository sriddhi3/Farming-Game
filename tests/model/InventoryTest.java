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
}