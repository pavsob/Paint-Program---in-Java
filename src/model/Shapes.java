package model;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Abstract class that shares common properties for each shape.
 * 
 * Also implements abstract method draw().
 * 
 */
public abstract class Shapes {

    protected boolean filled;
    protected int starPoints;
    protected Color color;
    protected ArrayList<Integer> position  = new ArrayList<Integer>();
    protected boolean regShape;

    public Shapes(boolean filled, Color color, ArrayList<Integer> position, boolean regShape) {
        this.filled = filled;
        this.color = color;
        this.position = new ArrayList<>(position);
        this.regShape = regShape;
    }

    public Shapes(boolean filled, Color color, ArrayList<Integer> position, int starPoints) {
        this.filled = filled;
        this.color = color;
        this.position = new ArrayList<>(position);
        this.starPoints = starPoints;
    }

    public Shapes(boolean filled, Color color, ArrayList<Integer> position) {
        this.filled = filled;
        this.color = color;
        this.position = new ArrayList<>(position);
    }

    public Shapes(Color color, ArrayList<Integer> position) {
        this.color = color;
        this.position = new ArrayList<>(position);
	}

    // each class that inherits have to contain draw method
    public abstract void draw(Graphics g);
}
