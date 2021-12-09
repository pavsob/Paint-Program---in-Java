package view;

import javax.swing.JPanel;

import model.DrawModel;

import java.awt.Graphics;

/**
 * Class that represents the JPanel to draw on.
 * 
 */
public class DrawPanel extends JPanel {

    private DrawModel model;

    public DrawPanel(DrawModel model) {
        this.model = model;
    }

    /**
     * Overrides the paintComponent method. Passes the Graphics to the model and calls model's drawShape method each time repaint() is called. 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.passGraphic(g);
        model.drawShape();
    }
}
