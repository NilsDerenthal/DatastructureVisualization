package my_project.view.input;

import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class ArrayInputReciever extends InputReceiver{

    /**
     * Objekterzeugung
     *
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public ArrayInputReciever(ProgramController programController) {
        super(programController);
    }

    @Override
    public void keyPressed(int key) {
        switch (key) {
            case KeyEvent.VK_RIGHT -> programController.moveOnArray(1, 0);
            case KeyEvent.VK_LEFT -> programController.moveOnArray(-1, 0);
            case KeyEvent.VK_UP -> programController.moveOnArray(0, -1);
            case KeyEvent.VK_DOWN -> programController.moveOnArray(0, 1);
            case KeyEvent.VK_SPACE -> programController.changeArr();

            case KeyEvent.VK_D -> programController.del();
            case KeyEvent.VK_A -> programController.add();

        }
    }
}
