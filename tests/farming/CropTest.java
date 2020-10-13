package farming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CropTest {
    private Crop crop = new Crop("Test crop", 10, 5);

    @Test
    public void getName() {
        assertEquals("Test crop", crop.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(10, crop.getPrice());
    }

    @Test
    public void getQuantity() {
        assertEquals(5, crop.getQuantity());
    }
}