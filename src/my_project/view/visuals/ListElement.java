package my_project.view.visuals;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListElement extends GraphicalObject {

    private ListElement prev;

    public ListElement(ViewController vc, ListElement prev) {
        this.prev = prev;
        y = 100;
        this.width = 20;
        this.height = 50;
        vc.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (prev != null) {
            x = (int) (prev.getX() + 20);
        } else {
            x = 100;
        }

        drawTool.drawRectangle(x, y, width, height);
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    @Override
    public void update(double dt) {

    }
}
