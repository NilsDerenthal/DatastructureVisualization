package my_project.view.input;

import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class StackInputReciever extends InputReceiver{
    /**
     * Objekterzeugung
     *
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public StackInputReciever(ProgramController programController) {
        super(programController);
    }

    @Override
    public void keyPressed(int key) {
        switch (key) {
            case KeyEvent.VK_RIGHT -> programController.addToStack();
            case KeyEvent.VK_LEFT -> programController.removeFromStack();
            case KeyEvent.VK_SPACE -> programController.changeTopOfStack();
        }
    }
}
