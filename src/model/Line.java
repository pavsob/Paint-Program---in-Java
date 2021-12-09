package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Class that draws the line.
 */
public class Line extends Shapes {
    
    public Line (Color color, ArrayList<Integer> position) {
        super(color, position);
    }

     /**
     * Decide the way to draw the shape into the drawPanel.
     * 
     * Sets position and colour.
     */
    public void draw(Graphics g) {
        int x1 = position.get(0);
        int y1 = position.get(1);
        int x2 = position.get(2);
        int y2 = position.get(3);
        g.setColor(color);

        g.drawLine(x1, y1, x2, y2);
    }
}
