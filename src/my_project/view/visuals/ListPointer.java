package my_project.view.visuals;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListPointer extends GraphicalObject {

    private ListElement cur;

    @Override
    public void draw(DrawTool drawTool) {
        if (cur != null)
            drawTool.drawCircle(cur.getX(), 10, 5);
        //System.out.println(cur);

    }

    public void setCur(ListElement cur) {
        this.cur = cur;
    }
}
