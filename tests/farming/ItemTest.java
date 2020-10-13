package farming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item item = new Item("test item", 20);

    @Test
    public void getName() {
        assertEquals("test item", item.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(20, item.getPrice());
    }
}