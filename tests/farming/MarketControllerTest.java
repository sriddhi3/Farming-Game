package farming;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class MarketControllerTest {
    private MarketController marketController = new MarketController();

    @Test
    public void testInventory() {
        assertNotNull(marketController);
    }

}