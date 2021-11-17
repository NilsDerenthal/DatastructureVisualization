package my_project.view.input;

import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class ListInputReciever extends InputReceiver {
    /**
     * Objekterzeugung
     *
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public ListInputReciever(ProgramController programController) {
        super(programController);
    }

    @Override
    public void keyPressed(int key) {
        switch (key) {
            case KeyEvent.VK_RIGHT -> programController.moveOnList();
            case KeyEvent.VK_SPACE -> programController.append();
        }
    }
}
