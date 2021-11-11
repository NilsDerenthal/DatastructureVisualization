package my_project.view.input;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;

import java.awt.event.MouseEvent;

public class MenuInputReciever extends InputReceiver {

    /**
     * Objekterzeugung
     *
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController    Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public MenuInputReciever(ProgramController programController) {
        super(programController);
    }
}
