package tests;

import model.*;
// import view.DrawGuiView;
// import view.DrawPanel;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.awt.Graphics;

public class EllipseTest {

    private DrawModel model;
    // private Ellipse ellipse;

    // private DrawPanel panel;

    // private Graphics curG;
    // private boolean filled = true;
    // private Color color = Color.BLACK;
    // private ArrayList<Integer> position = new ArrayList<Integer>(Arrays.asList(10,10,120,130));
    // private boolean regShape = false; 

    @Before
    public void setup() {
        model = new DrawModel();
        //panel = new DrawPanel(model);
        model.setSelectedShape("ellipse");
        model.setColor(Color.BLACK);
        model.setFilled(true);
        model.setPosition(10, 10, 120, 130);
        model.setRegularShape(false);
        model.addShape();
        //curG = model.getCurrentGraphic();
        //ellipse = new Ellipse(filled, color, position, regShape);
    }

    @Test
    public void ellipseExistsTest() {
        assertNotNull(model.getDrawnArray().get(0));
        assertTrue(model.getDrawnArray().get(0) instanceof Ellipse);
    }

    // Here I was trying to come up with the test for draw(Graphics g) method
    /**
     * panel.repaint() - passes needed Graphic into the shape and calls method that creates the shape, adds it into array and apply draw method on it
     * otherwise there would have to be created separate Graphic overriding all its methods
     */
    // @Test
    // public void elllipseTest() {
    //     model.setFilled(true);
    //     model.setPosition(10, 10, 120, 130);
    //     model.addShape();
    //     panel.repaint();
    //     assertArrayEquals(curG.fillOval(10, 10, Math.abs(120 - 10), Math.abs(130 - 10)), model.drawShape());
    // }
}
