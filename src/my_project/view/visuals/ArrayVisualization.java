package my_project.view.visuals;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.function.BiConsumer;

public class ArrayVisualization extends GraphicalObject {

    public final static int WIDTH = 30;

    private int pointerX, pointerY;

    private final ArrayElement[][] arr;

    public ArrayVisualization(ViewController vc) {
        vc.draw(this);
        arr = new ArrayElement[20][10];
        forEach((i, j) -> arr[i][j] = new ArrayElement(i * WIDTH + WIDTH, j * WIDTH + WIDTH));
    }

    @Override
    public void draw(DrawTool drawTool) {

        forEach((i, j) -> {
            drawTool.setCurrentColor(100, 100, 100, 255);
            if (i == pointerX && j == pointerY) {
                drawTool.drawFilledRectangle(i * WIDTH + WIDTH, j * WIDTH + WIDTH, WIDTH, WIDTH);
            } else {
                drawTool.drawRectangle(i * WIDTH + WIDTH, j * WIDTH + WIDTH, WIDTH, WIDTH);
            }

            drawTool.setCurrentColor(0, 0, 0, 255);
            arr[i][j].draw(drawTool);
        });
    }

    private void forEach (BiConsumer<Integer, Integer> action) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                action.accept(i, j);
            }
        }
    }

    public void changePointerX(int amount) {
        this.pointerX += amount;
    }

    public void changePointerY(int amount) {
        this.pointerY += amount;
    }

    public ArrayElement get () {
        return arr[pointerX][pointerY];
    }

    public void set() {
        arr[pointerX][pointerY] = new ArrayElement(pointerX, pointerY);
    }

    @Override
    public void update(double dt) {

    }

    public void del() {
        arr[pointerX][pointerY] = null;
    }
}
