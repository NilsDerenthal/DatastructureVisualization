package my_project.view.visuals;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListPointer extends GraphicalObject {

    private ListElement cur;

    @Override
    public void draw(DrawTool drawTool) {
        if (cur != null) {
            x = cur.getX() + cur.getWidth()/2;
            y = 60;
            drawTool.drawFilledPolygon(
                    x - 4, y,
                    x - 4, y + 10,
                    x - 12, y + 10,
                    x, y + 20,
                    x + 12, y + 10,
                    x + 4, y + 10,
                    x + 4, y
            );
        }
    }

    public void setCur(ListElement cur) {
        this.cur = cur;
        cur.highlight();
    }
}
