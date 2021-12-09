package main;

import controller.DrawController;
import model.DrawModel;
import view.DrawGuiView;

/**
 * Class that initiate and runs vector drawing GUI.
 * 
 */
public class DrawMain {
    public static void main(String[] args) {

        // create Model
        DrawModel model = new DrawModel();

        // Create controller
        DrawController controller = new DrawController(model);
        
        // Create View (GUI)
        new DrawGuiView(model, controller);
    }
}
