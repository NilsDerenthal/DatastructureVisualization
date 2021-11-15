package my_project.view.input;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public abstract class InputReceiver extends InteractableAdapter {

    protected final ProgramController programController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public InputReceiver (ProgramController programController){
        this.programController = programController;
    }
}
