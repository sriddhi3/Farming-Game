package farming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeedTest {
    private Seed seed = new Seed(10, "test seed");

    @Test
    public void getQuantity() {
        assertEquals(10, seed.getQuantity());
    }

    @Test
    public void getName() {
        assertEquals("test seed", seed.getName());
    }
}