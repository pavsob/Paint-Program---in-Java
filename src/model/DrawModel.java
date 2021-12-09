package model;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Class that represents the model of vector drawing GUI.
 * 
 * It deals with a collection of abstract shapes, with operations to select the current drawing shape, create it and store it in an arrayList.
 * It provides methods to undo and redo drawing, setup whether drawings are filled, setup colour, receives drawing position, and in case of 
 * star the number of points.
 * 
 */
public class DrawModel {

    private boolean regShape = false;
    private String selectedShape = "line";
    private int starPoints = 5;
    private ArrayList<Shapes> drawnShapes = new ArrayList<Shapes>();
    // array for undo shapes
    private ArrayList<Shapes> undoShapes = new ArrayList<Shapes>();

    private boolean filled = true;
    private Color color = Color.BLACK;
    private ArrayList<Integer> position  = new ArrayList<Integer>();
    private Graphics g;

    private PropertyChangeSupport notifier;

    public DrawModel() {
        notifier = new PropertyChangeSupport(this);
    }

    /**
     * Method that adds observer.
     * 
     * @param listener
     */
    public void addObserver(PropertyChangeListener listener) {
        notifier.addPropertyChangeListener(listener);
    }

    /**
     * Receives Graphics from the paintComponent().
     * 
     * @param g
     */
    public void passGraphic(Graphics g) {
        this.g = g;
    }

    /**
     * Goes through the array of shapes and applies draw method at each object.
     */
    public void drawShape() {
        for (Shapes shape : drawnShapes) {
            shape.draw(g);
        }
    }

    /**
     * Creates and adds Shapes object to the array according to selectedShape and notifies the view there is a change in the model.
     */
    public void addShape() {
        if (selectedShape.equals("rectangle")) {
            drawnShapes.add(new Rectangle(filled, color, position, regShape));
        }
        else if (selectedShape.equals("ellipse")) {
            drawnShapes.add(new Ellipse(filled, color, position, regShape));
        }
        else if (selectedShape.equals("line")) {
            drawnShapes.add(new Line(color, position));
        }
        else if (selectedShape.equals("star")) {
            drawnShapes.add(new FiveStar(filled, color, position, starPoints));
        }
        notifier.firePropertyChange("repaint", null, null);
    }

    /**
     * Handles undo action and notifies the view there is a change in the model.
     */
    public void undo() {
        try {
            int indexLastShape = drawnShapes.size() - 1;
            undoShapes.add(drawnShapes.get(indexLastShape));
            drawnShapes.remove(indexLastShape);
            notifier.firePropertyChange("repaint", null, null);
        }
        catch (IndexOutOfBoundsException ioobe) {}
    }

    /**
     * Handles redo action and notifies the view there is a change in the model.
     */
    public void redo() {
        try {
            int indexLastShape = undoShapes.size() - 1;
            drawnShapes.add(undoShapes.get(indexLastShape));
            undoShapes.remove(indexLastShape);
            notifier.firePropertyChange("repaint", null, null);
        }
        catch (IndexOutOfBoundsException ioobe) {}
    }

    /**
     * Handles clear action and notifies the view there is a change in the model.
     */
    public void clear() {
        drawnShapes.clear();
        undoShapes.clear();
        notifier.firePropertyChange("repaint", null, null);
    }

    /**
     * Sets position of the currently drawn shape and call addShape() to add it in the array of drawn shapes.
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void setPosition(int x1, int y1, int x2, int y2) {
        position.clear();
        position.add(x1);
        position.add(y1);
        position.add(x2);
        position.add(y2);
        addShape();
    }

    /**
     * Sets shape that is going to be drawn.
     * 
     * @param selectedShape
     */
    public void setSelectedShape(String selectedShape) {
        this.selectedShape = selectedShape;
    }

    /**
     * Sets whether the shape is going to be filled.
     * 
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Sets the colour for of the shape.
     * 
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets whether the drawn object is a regular shape.
     * 
     * @param regShape
     */
    public void setRegularShape(boolean regShape) {
        this.regShape = regShape;
    }

    /**
     * Sets number of star points.
     * 
     * @param starPoints
     */
    public void setStarPoints(int starPoints) {
        if (starPoints > 2) {
            this.starPoints = starPoints;
        }
    }

    /**
     * Method created for testing.
     * @return
     */
    public ArrayList<Shapes> getDrawnArray() {
        return drawnShapes;
    }

    /**
     * Method created for testing.
     * 
     * @return
     */
    public ArrayList<Shapes> getUndoArray() {
        return undoShapes;
    }

    /**
     * Method created for testing.
     * 
     * @return
     */
    public Graphics getCurrentGraphic() {
        return g;
    }
}
