package tests;

import model.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;

public class FiveStarTest {

    private DrawModel model;
    
    @Before
    public void setup() {
        model = new DrawModel();
        model.setSelectedShape("star");
        model.setColor(Color.BLACK);
        model.setStarPoints(20); //cannot pass number lower than 3, also the view protects againt String with letters or not integers
        model.setPosition(10, 10, 120, 130);
        model.addShape();
    }

    @Test
    public void ellipseExistsTest() {
        assertNotNull(model.getDrawnArray().get(0));
        assertTrue(model.getDrawnArray().get(0) instanceof FiveStar);
    }
}
