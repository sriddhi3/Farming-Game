package view;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarketControllerTest {
    private MarketController marketController = new MarketController();

    @Test
    public void initialize() {
        assertNotNull(marketController);
    }
}