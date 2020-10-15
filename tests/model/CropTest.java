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
}