package my_project.view.input;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;

import java.awt.event.MouseEvent;

public class QueueInputReciever extends InputReceiver{

    /**
     * Objekterzeugung
     *
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController    Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public QueueInputReciever(ProgramController programController) {
        super(programController);
    }

    /**
     * Wird einmalig aufgerufen, wenn eine Maustaste losgelassen wurde.
     *
     * @param e Das übergebene Objekt der Klasse MouseEvent enthält alle Information über das Ereignis.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            programController.addBallToQueue();
        } else if (e.getButton() == MouseEvent.BUTTON3){
            programController.deleteBallFromQueue();
        }
    }
}
