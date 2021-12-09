package tests;

import model.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;

public class RectangleTest {

    private DrawModel model;
    
    @Before
    public void setup() {
        model = new DrawModel();
        model.setSelectedShape("rectangle");
        model.setColor(Color.BLACK);
        model.setFilled(true);
        model.setPosition(10, 10, 120, 130);
        model.setRegularShape(false);
        model.addShape();
    }

    @Test
    public void ellipseExistsTest() {
        assertNotNull(model.getDrawnArray().get(0));
        assertTrue(model.getDrawnArray().get(0) instanceof Rectangle);
    }
}
