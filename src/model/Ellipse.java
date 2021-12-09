package model;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Class that draws the ellipse.
 * 
*/
public class Ellipse extends Shapes {

    public Ellipse (boolean filled, Color color, ArrayList<Integer> position, boolean regShape) {
        super(filled, color, position, regShape);
    }

    /**
     * Decide the way to draw the shape into the drawPanel
     * 
     * Sets position and colour. It decides whether it is a regular shape. It decides whether the shape is filled. It decides the way of drawing 
     * so it is drawn in the direction where mouse is released.
     */
    public void draw(Graphics g) {
        int x1 = position.get(0);
        int y1 = position.get(1);
        int x2 = position.get(2);
        int y2 = position.get(3);
        g.setColor(color);

        if (regShape == true) {
            if (filled == true) {
                if(x1 < x2 && y1 < y2) {
                    g.fillOval(x1, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else if (x1 < x2 && y1 > y2) {
                    g.fillOval(x1, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else if (x1 > x2 && y1 < y2) {
                    g.fillOval(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else {
                    g.fillOval(x2, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
                }
            }
            else {
                if(x1 < x2 && y1 < y2) {
                    g.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else if (x1 < x2 && y1 > y2) {
                    g.drawOval(x1, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else if (x1 > x2 && y1 < y2) {
                    g.drawOval(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
                } else {
                    g.drawOval(x2, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
                }
            }
        }
        else {
            if (filled == true) {
                if(x1 < x2 && y1 < y2) {
                    g.fillOval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else if (x1 < x2 && y1 > y2) {
                    g.fillOval(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else if (x1 > x2 && y1 < y2) {
                    g.fillOval(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else {
                    g.fillOval(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
                }
            }
            else {
                if(x1 < x2 && y1 < y2) {
                    g.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else if (x1 < x2 && y1 > y2) {
                    g.drawOval(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else if (x1 > x2 && y1 < y2) {
                    g.drawOval(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
                } else {
                    g.drawOval(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
                }
            }
        }
    }
}
