package design_pattern.decorator;

/**
 * @author : jiang
 * @time : 2018/5/9 18:58
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape: Rectangle");
    }
}
