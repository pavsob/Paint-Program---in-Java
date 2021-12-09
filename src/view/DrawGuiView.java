package view;

import model.DrawModel;
import controller.DrawController;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import java.awt.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class that represents the view of vector drawing GUI.
 * 
 */
public class DrawGuiView implements ActionListener, ItemListener, KeyListener, PropertyChangeListener {

    private DrawModel model;
    private DrawController controller;
    private DrawPanel drawPanel;

    private JFrame mainFrame;
    private JPanel drawControlPanel;

    private static int DEFAULT_FRAME_WIDTH = 1000;
    private static int DEFAULT_FRAME_HEIGHT = 700;

    // buttons
    private JButton clearButton;
    private JButton lineButton;
    private JButton rectangleButton;
    private JButton ellipseButton;
    private JButton colorButton;
    private JButton fiveStarButton;
    private JButton applyButton;
    private JTextField starPoints;
    private JCheckBox filledButton;
    private JMenuItem undo;
    private JMenuItem redo;

    /**
     * Constructor setups the GUI, add listeners, and calls methods for adding buttons.
     * 
     * @param model
     * @param controller
     */
    public DrawGuiView(DrawModel model, DrawController controller) {
        this.model = model;
        this.controller = controller;

        // create frame for GUI
        mainFrame = new JFrame("Vector Drawing");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT); // set frame size
        MenuBarSetUp();

        // create JPanel with buttons
        drawControlPanel = new JPanel();
        mainFrame.getContentPane().add(drawControlPanel, BorderLayout.PAGE_START);
        addControlElements();

        // create panel for drawing
        drawPanel = new DrawPanel(model);
        mainFrame.getContentPane().add(drawPanel, BorderLayout.CENTER);

        mainFrame.setFocusable(true);
        mainFrame.setVisible(true);

        mainFrame.addKeyListener(this);
        filledButton.addKeyListener(this);
        addKeyListenerForButtons(this);
        addActionListenerForButtons(this);
        filledButton.addItemListener(this);
        drawMouseListener();
        model.addObserver(this);
    }

    /**
     * Litens to changes in the model. When change is registered, it calls repaint().
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        drawPanel.repaint();
    }

    /**
     * Setups menu bar.
     */
    public void MenuBarSetUp() {
        JMenuBar menu = new JMenuBar();
        JMenu edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        edit.add(undo);
        edit.add(redo);
        menu.add(edit);
        mainFrame.setJMenuBar(menu);
    }

    /**
     * Adds buttons to the GUI.
     */
    private void addControlElements() {
        clearButton = new JButton("Clear");
        rectangleButton = new JButton("Rectangle");
        lineButton = new JButton("Line");
        ellipseButton = new JButton("Ellipse");
        colorButton = new JButton("Choose Colour");
        fiveStarButton = new JButton("Star");
        JLabel s = new JLabel("Number of Star points: ");
        starPoints = new JTextField(5);
        applyButton = new JButton("Apply");
        filledButton = new JCheckBox("Filled");
        filledButton.setSelected(true);
        JLabel l = new JLabel("Regular shape - hold shift");
        drawControlPanel.add(l);
        drawControlPanel.add(clearButton);
        drawControlPanel.add(lineButton);
        drawControlPanel.add(filledButton);
        drawControlPanel.add(rectangleButton);
        drawControlPanel.add(ellipseButton);
        drawControlPanel.add(fiveStarButton);
        drawControlPanel.add(s);
        drawControlPanel.add(starPoints);
        drawControlPanel.add(applyButton);
        drawControlPanel.add(colorButton);
    }

    /**
     * Adds Action Listeners for buttons.
     * 
     * @param al
     */
    public void addActionListenerForButtons(ActionListener al) {
        lineButton.addActionListener(al);
        rectangleButton.addActionListener(al);
        ellipseButton.addActionListener(al);
        colorButton.addActionListener(al);
        fiveStarButton.addActionListener(al);
        clearButton.addActionListener(al);
        undo.addActionListener(al);
        redo.addActionListener(al);
        applyButton.addActionListener(al);
    }

    /**
     * Adds Key Listeners for buttons. (I've done this because when I clicked any button the focus was on that button and 
     * the panel did not listen for the keys.)
     * 
     * @param kl
     */
    public void addKeyListenerForButtons(KeyListener kl) {
        clearButton.addKeyListener(kl);
        lineButton.addKeyListener(kl);
        rectangleButton.addKeyListener(kl); 
        ellipseButton.addKeyListener(kl);
        colorButton.addKeyListener(kl); 
        fiveStarButton.addKeyListener(kl); 
    }

    /**
     * Controls what controller should do when certain action is performed.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lineButton) {
            controller.shapeSelection("line");
        } else if (e.getSource() == rectangleButton) {
            controller.shapeSelection("rectangle");
        } else if (e.getSource() == ellipseButton) {
            controller.shapeSelection("ellipse");
        } else if (e.getSource() == fiveStarButton) {
            controller.shapeSelection("star");
        } else if (e.getSource() == colorButton) {
            Color color = JColorChooser.showDialog(null, "Colour Chooser", null);
            if (color != null) {
                controller.colorSelection(color);
            }
        } else if (e.getSource() == undo) {
            controller.undoControl();
        } else if (e.getSource() == redo) {
            controller.redoControl();
        } else if (e.getSource() == clearButton) {
            controller.clearControl();
        } else if (e.getSource() == applyButton) {
            controller.applyControl(starPoints.getText());
        }
        
    }

    /**
     * Calls controler method to set whether shape should be filled.
     */
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            controller.filledInfo(true);
        }
        else {
            controller.filledInfo(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {}
    /**
     * When the shift is pressed it calls controller to draw regular shapes.
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
            controller.shiftControl(true);
        }
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
            controller.shiftControl(false);
        }
    }

    /**
     * Listens to the mouse actions in drawPanel and calls contoller's methods.
     */
    public void drawMouseListener() {
        drawPanel.addMouseListener(new MouseListener () {
            public void mousePressed(MouseEvent me) {
                //sent info to controller
                controller.mPressed(me);
            }
            public void mouseReleased(MouseEvent me) {
                //sent info to controller
                controller.mReleased(me);
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
        });
    }
}
