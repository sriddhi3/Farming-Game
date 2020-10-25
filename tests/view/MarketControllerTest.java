package view;

import org.junit.Test;

import static org.junit.Assert.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MarketControllerTest {
    private MarketController marketController = new MarketController();

    @Test
    public void initialize() {
        assertNotNull(marketController);
    }
}