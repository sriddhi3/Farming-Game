package farming;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory inventory = new Inventory();

    @Test
    public void testCapacity() {
        assertNotNull(inventory.capacity);
    }

    @Test
    public void testTotal() {
        assertNotNull(inventory.total);
    }
}