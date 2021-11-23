package my_project.view.visuals;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class ArrayElement extends GraphicalObject {

    private Color color;

    public ArrayElement(int x, int y) {
        this.x = x;
        this.y = y;
        setColor();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color);
        drawTool.drawFilledCircle(x + ArrayVisualization.WIDTH / 2f, y + ArrayVisualization.WIDTH / 2f, 10);
    }

    public void setColor () {
        color = Color.getHSBColor((float) Math.random(), 1, 1);
    }
}
