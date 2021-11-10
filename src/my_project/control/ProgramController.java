package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import my_project.model.datastructures.queue.QueueBall;
import my_project.view.input.InputReceiver;
import my_project.view.visuals.components.ButtonFactory;
import my_project.view.visuals.panes.Menu;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;
    private Queue<QueueBall> ballQueue;
    private QueueBall lastBallInQueue;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        new InputReceiver(this, viewController);
        ballQueue = new Queue<>();
        lastBallInQueue = null;

        viewController.draw(ButtonFactory.get(viewController));
    }

    public void addBallToQueue(){
        QueueBall newQueueBall = new QueueBall(650,50, lastBallInQueue, viewController);
        ballQueue.enqueue(newQueueBall);
        lastBallInQueue = newQueueBall;
    }

    public void deleteBallFromQueue(){
        if(!ballQueue.isEmpty()){
            if(ballQueue.front().tryToDelete()) ballQueue.dequeue();
        }
    }

    /**
     * Aufruf bei Mausklick
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    /**
     * Wrapper for the scene index
     */
    public enum Scene {
        MENU(0),
        STACK(1),
        LIST(2),
        QUEUE(3);

        private final int index;

        Scene(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
