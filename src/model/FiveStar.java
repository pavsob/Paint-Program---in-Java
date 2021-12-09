package model;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Class that draws the star.
 * 
 */
public class FiveStar extends Shapes {

    public FiveStar (boolean filled, Color color, ArrayList<Integer> position, int starPoints) {
        super(filled, color, position, starPoints);
    }
    
     /**
     * Decide the way to draw the shape into the drawPanel
     * 
     * Sets position and colour. The center of the star is the position where the mouse is pressed and where 
     * the mouse is released it defines outer radius of the star. Decides how many points of the star to draw.
     */
    public void draw(Graphics g) {
        int x1 = position.get(0);
        int y1 = position.get(1);
        int x2 = position.get(2);
        int y2 = position.get(3);
        
        int xOut = Math.abs(x2 - x1);
        int yOut = Math.abs(y2 - y1);
        double outerRadius = (Math.sqrt(Math.pow(xOut, 2) + Math.pow(yOut, 2))); 

        Graphics2D gr = (Graphics2D) g;
        g.setColor(color);

        if (starPoints == 5) {
            gr.draw(createDefaultStar(outerRadius, x1, y1));
        }
        else {
            gr.draw(createStar(x1, y1, outerRadius / 3, outerRadius, starPoints, 0));
        }
    }

    // The source of the subsequent code is: https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
    /**
     * It draws the star using Path2D. It goes by the angel and draws each line of the star.
     * 
     * @param radius
     * @param centerX
     * @param centerY
     * @return returns the path to draw
     */
    private static Shape createDefaultStar(double radius, double centerX, double centerY) {
        return createStar(centerX, centerY, radius / 2.63, radius, 5, Math.toRadians(-18));
    }
    private static Shape createStar(double centerX, double centerY, double innerRadius, double outerRadius, int numRays, double startAngleRad) {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++) {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }
}
