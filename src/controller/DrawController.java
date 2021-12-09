package controller;

import model.DrawModel;

import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * Class that represents the controller of vector drawing GUI.
 * 
 * When it is activated in the view, it controlls the actions in the model.
 * 
 */
public class DrawController {

    private DrawModel model;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawController(DrawModel model) {
        this.model = model;
    }

    /**
     * Sets x1 and y1 when the mouse is pressed.
     * 
     * @param me
     */
    public void mPressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
    }

    /**
     * Sets x2 and y2 when the mouse is released and calls set position in the model.
     * 
     * @param me
     */
    public void mReleased(MouseEvent me) {
        x2 = me.getX();
        y2 = me.getY();
        model.setPosition(x1,y1,x2,y2);
    }

    /**
     * Sets whether the shape will be filled.
     * 
     * @param fInfo
     */
    public void filledInfo(boolean fInfo) {
        model.setFilled(fInfo);
    }

    /**
     * Sets colour of the shape.
     * 
     * @param color
     */
    public void colorSelection(Color color) {
        model.setColor(color);
    }

    /**
     * Controls undo method in the model.
     */
    public void undoControl() {
        model.undo();
    }

    /**
     * Controls redo method in the model.
     */
    public void redoControl() {
        model.redo();
    }

    /**
     * Controls whether the shift key is pressed to draw regular shape.
     * 
     * @param shiftPressed
     */
    public void shiftControl(boolean shiftPressed) {
        model.setRegularShape(shiftPressed);
    }

    /**
     * Controlls clear method in the model.
     */
    public void clearControl() {
        model.clear();
    }

    /**
     * Controlls setting the shape in the model.
     */
    public void shapeSelection(String selectedShape) {
        model.setSelectedShape(selectedShape);
    }

    /**
     * Controlls number of star points.
     * 
     * @param pointsTxt
     */
    public void applyControl(String pointsTxt) {
        try {
            int pointsNum = Integer.parseInt(pointsTxt);
            model.setStarPoints(pointsNum);
        } catch (NumberFormatException e) {}
    }
}
