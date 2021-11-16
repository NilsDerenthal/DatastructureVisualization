package my_project.view.visuals.components;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.Random;

public class StackElement extends GraphicalObject {

    private final ViewController viewController;
    private boolean leaving;
    private Color color;

    private final static int
            SPEED = 200,
            STOP = 100;

    public StackElement(ViewController viewController, int x, int y) {
        this.viewController = viewController;
        this.x = x;
        this.y = y;
        changeColor();
        leaving = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color);
        drawTool.drawFilledRectangle(x, y, 500, 1);
    }

    @Override
    public void update(double dt) {
        if (x < STOP) {
            x += SPEED * dt;
        } else {
            if (leaving) {
                x += SPEED * 3 * dt;

                if (x > 3 * STOP) {
                    viewController.removeDrawable(this);
                }
            } else {
                x = STOP;
            }
        }
    }

    public void changeColor () {
        Random generator = new Random();
        float hue = generator.nextFloat();

        color = Color.getHSBColor(hue, 1, 1);
    }

    public boolean remove () {
        if (x == STOP)
            leaving = true;
        return leaving;
    }
}
