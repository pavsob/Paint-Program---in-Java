package tests;

import model.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;

public class LineTest {

    private DrawModel model;
    
    @Before
    public void setup() {
        model = new DrawModel();
        model.setSelectedShape("line");
        model.setColor(Color.BLACK);
        model.setPosition(10, 10, 120, 130);
        model.addShape();
    }

    @Test
    public void ellipseExistsTest() {
        assertNotNull(model.getDrawnArray().get(0));
        assertTrue(model.getDrawnArray().get(0) instanceof Line);
    }
}