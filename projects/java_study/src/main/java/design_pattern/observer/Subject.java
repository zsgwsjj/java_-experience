package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/5/9 18:12
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public Subject setState(int state) {
        this.state = state;
        notifyAllObservers();
        return this;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
