package tests;

import model.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DrawModelTest {

    private DrawModel model;
    ArrayList<Integer> position  = new ArrayList<Integer>();

    @Before
    public void setup() {
        model = new DrawModel();

    }

    @Test
    public void modelExists() {
        assertNotNull(model);
    }

    /**
     * setPosition method will always integer numbers from the view.
     * setSelectedShape will always receive one of these string from the view: "rectangle", "line", "ellipse", "star"
     */
    @Test
    public void testEmptyShapesArray() {
        assertEquals(0, model.getDrawnArray().size());
    }
    @Test
    public void setPosition_addShapeTest() {
        model.setSelectedShape("rectangle");
        model.setPosition(5, 5, 5, 5); //also calls addShape
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Rectangle);
    }
    @Test
    public void addShapeDefaultLineTest() {
        model.addShape();
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Line);
    }
    @Test
    public void addShapeEllipseTest() {
        model.setSelectedShape("ellipse");
        model.addShape();
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Ellipse);
    }
    @Test
    public void addShapeStarTest() {
        model.setSelectedShape("star");
        model.addShape();
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof FiveStar);
    }
    @Test
    public void addShapeLineTest() {
        model.setSelectedShape("line");
        model.addShape();
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Line);
    }
    @Test
    public void addShapeRectangleTest() {
        model.setSelectedShape("rectangle");
        model.addShape();
        assertEquals(1, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Rectangle);
    }
    @Test
    public void addMoreShapesTest() {
        model.setSelectedShape("rectangle");
        model.addShape();
        model.setSelectedShape("line");
        model.addShape();
        model.setSelectedShape("star");
        model.addShape();
        model.setSelectedShape("ellipse");
        model.addShape();
        assertEquals(4, model.getDrawnArray().size());
        assertTrue(model.getDrawnArray().get(0) instanceof Rectangle);
        assertTrue(model.getDrawnArray().get(1) instanceof Line);
        assertTrue(model.getDrawnArray().get(2) instanceof FiveStar);
        assertTrue(model.getDrawnArray().get(3) instanceof Ellipse);
    }
    // This should never happen since view is sending only shapes above
    @Test
    public void unimplementedShape() {
        model.setSelectedShape("krychle");
        model.addShape();
        assertEquals(0, model.getDrawnArray().size());
    }

    /**
     * undo, redo and clear testing
     */
    @Test
    public void undoOnEmptyArrayTest() {
        try {
            model.undo();
        }
        catch (IndexOutOfBoundsException ioobe) {
            fail("It should catch IndexOutOfBoundsException");
        }
    }
    @Test
    public void redoOnEmptyArrayTest() {
        try {
            model.redo();
        }
        catch (IndexOutOfBoundsException ioobe) {
            fail("It should catch IndexOutOfBoundsException");
        }
    }
    @Test
    public void undoTest() {
        model.setSelectedShape("rectangle");
        model.addShape();
        model.setSelectedShape("line");
        model.addShape();
        model.setSelectedShape("star");
        model.addShape();
        model.setSelectedShape("ellipse");
        model.addShape();
        model.undo();
        assertEquals(3, model.getDrawnArray().size());
        assertEquals(1, model.getUndoArray().size());
        assertTrue(model.getUndoArray().get(0) instanceof Ellipse);
    }
    @Test
    public void redoTest() {
        model.setSelectedShape("rectangle");
        model.addShape();
        model.setSelectedShape("line");
        model.addShape();
        model.setSelectedShape("star");
        model.addShape();
        model.setSelectedShape("ellipse");
        model.addShape();
        model.undo();
        model.undo();
        assertEquals(2, model.getDrawnArray().size());
        assertEquals(2, model.getUndoArray().size());
        model.redo();
        assertEquals(3, model.getDrawnArray().size());
        assertEquals(1, model.getUndoArray().size());
        assertTrue(model.getUndoArray().get(0) instanceof Ellipse);
    }
    @Test
    public void clearTest() {
        model.setSelectedShape("rectangle");
        model.addShape();
        model.setSelectedShape("line");
        model.addShape();
        model.setSelectedShape("star");
        model.addShape();
        model.setSelectedShape("ellipse");
        model.addShape();
        model.clear();
        assertEquals(0, model.getDrawnArray().size());
        assertEquals(0, model.getUndoArray().size());
    }
}
