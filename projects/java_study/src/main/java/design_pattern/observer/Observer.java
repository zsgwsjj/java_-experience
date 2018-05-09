package design_pattern.observer;

/**
 * @author : jiang
 * @time : 2018/5/9 18:15
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
