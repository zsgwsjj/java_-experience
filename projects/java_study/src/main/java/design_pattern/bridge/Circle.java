package design_pattern.bridge;

/**
 * @author : jiang
 * @time : 2018/5/10 11:01
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
