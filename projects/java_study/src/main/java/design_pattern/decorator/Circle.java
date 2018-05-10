package design_pattern.decorator;

/**
 * @author : jiang
 * @time : 2018/5/9 19:03
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape: Circle");
    }
}
