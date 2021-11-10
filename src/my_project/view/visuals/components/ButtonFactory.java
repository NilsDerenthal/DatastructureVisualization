package my_project.view.visuals.components;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.simple_gui.Button;
import KAGO_framework.view.simple_gui.ButtonHandler;

public class ButtonFactory {

    private ButtonFactory() {}

    public static Button get (ViewController vc) {
        return new Button(new ButtonHandler() {
            @Override
            public void processButtonClick(int code) {
                System.out.println(code);
            }

            @Override
            public int getSceneIndex() {
                return 0;
            }

            @Override
            public ViewController getViewController() {
                return vc;
            }
        }, -1,0,0,"abc", 11);
    }
}
