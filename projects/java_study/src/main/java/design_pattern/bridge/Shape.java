package design_pattern.bridge;

/**
 * @author : jiang
 * @time : 2018/5/10 10:58
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
