package design_pattern.bridge;

/**
 * @author : jiang
 * @time : 2018/5/10 10:57
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle color:green,radius: " + radius + ", x:" + x + ", y:" + y);
    }
}
