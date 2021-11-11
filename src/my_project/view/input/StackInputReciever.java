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
        if (key == KeyEvent.VK_LEFT) {
            programController.addToStack();
        }
    }
}
