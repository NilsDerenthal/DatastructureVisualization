package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.view.input.ArrayInputReciever;
import my_project.view.visuals.*;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private final int
            MENU = 0,
            QUEUE = 1,
            STACK = 2,
            LIST = 3;


    // Referenzen
    private final ViewController viewController;
    private Queue<QueueBall> ballQueue;
    private QueueBall lastBallInQueue;

    private Stack<StackElement> stack;
    private List<ListElement> list;

    private ListPointer pointer;

    private ArrayVisualization arrVis;


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
        //viewController.register(new QueueInputReciever(this));
        //viewController.register(new StackInputReciever(this));
        //viewController.register(new ListInputReciever(this));
        viewController.register(new ArrayInputReciever(this));

        ballQueue = new Queue<>();
        stack = new Stack<>();
        list = new List<>();
        pointer = new ListPointer();
        arrVis = new ArrayVisualization(viewController);

        viewController.draw(pointer);

        lastBallInQueue = null;
    }

    public void addToStack() {
        int newY;

        if (stack.isEmpty()) {
            newY = 350;
        } else {
            newY = stack.top().getYOfNext();
        }

        StackElement newElement = new StackElement(viewController, -10, newY);
        stack.push(newElement);
    }

    public void removeFromStack() {
        if (!stack.isEmpty()) {
            if (stack.top().remove())
                stack.pop();
        }
    }

    public void changeTopOfStack() {
        if (!stack.isEmpty()) {
            stack.top().changeColor();
        }
    }

    public void addBallToQueue(){
        QueueBall newQueueBall = new QueueBall(650, 50, lastBallInQueue, viewController);
        ballQueue.enqueue(newQueueBall);
        lastBallInQueue = newQueueBall;
    }

    public void deleteBallFromQueue(){
        if(!ballQueue.isEmpty()){
            if(ballQueue.front().tryToDelete()) ballQueue.dequeue();
        }
    }

    public void moveOnArray(int amountX, int amountY) {
        arrVis.changePointerX(amountX);
        arrVis.changePointerY(amountY);
    }

    public void changeArr() {
        arrVis.get().setColor();
    }

    public void del() {
        arrVis.del();
    }

    public void add() {
        arrVis.set();
    }

    public void append() {
        boolean empty = list.isEmpty();

        list.append(new ListElement(viewController, getPrev()));

        if (empty) {
            list.toFirst();
            pointer.setCur(list.getContent());
        }
    }

    public void change () {
        list.getContent().change();
    }

    public void remove() {
        list.getContent().remove();
        list.remove();
        if (!list.hasAccess()) {
            list.toFirst();
        }
        pointer.setCur(list.getContent());
    }

    public void moveOnList() {
        list.next();
        if (!list.hasAccess()) {
            list.toFirst();
        }
        pointer.setCur(list.getContent());
    }

    private ListElement getPrev() {
        ListElement toReturnBackTo = list.getContent();
        list.toLast();
        ListElement last = list.getContent();
        list.toFirst();

        while (list.getContent() != toReturnBackTo) {
            list.next();
        }

        return last;
    }

    // ignored
    /**
     * Aufruf bei Mausklick
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e) {}

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt) {}
}
