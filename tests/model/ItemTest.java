package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item item = new Item("test item", 50);

    @Test
    public void getName() {
        assertEquals("test item", item.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(50, item.getPrice());
    }
}