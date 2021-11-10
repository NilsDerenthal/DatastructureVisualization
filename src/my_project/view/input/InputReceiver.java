package my_project.view.input;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputReceiver extends InteractableAdapter {

    private final ProgramController programController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputReceiver(ProgramController programController, ViewController viewController){
        this.programController = programController;
        viewController.register(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            programController.addBallToQueue();
        } else if (e.getButton() == MouseEvent.BUTTON2){
            programController.deleteBallFromQueue();
        }
    }
}
