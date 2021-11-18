package my_project.view.visuals;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.Arrays;
import java.util.Random;

public class ListElement extends GraphicalObject {

    private ListElement prev;
    private int alpha;
    private boolean leaving;

    private final int[] rgb;

    public ListElement(ViewController vc, ListElement prev) {
        rgb = new int[]{100, 100, 100};
        setPrev(prev);
        y = 100;
        this.width = 25;
        this.height = 50;
        vc.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(rgb[0], rgb[1], rgb[2], alpha);
        drawTool.drawFilledRectangle(x, y, width, height);
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;

        if (prev != null) {
            x = (int) (prev.getX() + prev.getWidth() + 2);
        } else {
            x = 100;
        }
    }

    @Override
    public void update(double dt) {
        if (alpha < 256 && alpha >= 0) {
            alpha = !leaving ?
                    (int) Math.min(alpha + 255 * 1.5 * dt, 255) :
                    (int) Math.max(alpha - 255 * 1.5 * dt, 0);
        }

        if (leaving) {
            y += 500 * dt;
        }
    }

    public void highlight() {
        alpha = 100;
    }

    public void change () {
        Arrays.setAll(rgb, ignored -> new Random().nextInt(255));
    }

    public void remove() {
        leaving = true;
    }
}
