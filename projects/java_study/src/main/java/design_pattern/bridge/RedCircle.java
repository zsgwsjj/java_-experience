package design_pattern.bridge;

/**
 * @author : jiang
 * @time : 2018/5/10 10:56
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle color:red,radius: " + radius + ", x:" + x + ", y:" + y);
    }
}
