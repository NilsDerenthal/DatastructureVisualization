package my_project.view.visuals.components;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class StackElement extends GraphicalObject {

    public StackElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0, 0);
        drawTool.drawRectangle(x, y, 20, 3);
        System.out.println(x + " " + y);
    }

    @Override
    public void update(double dt) {
        if (x < 100) {
            x += 200 * dt;
        }
    }
}
