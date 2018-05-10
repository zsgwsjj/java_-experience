package design_pattern.proxy;

/**
 * @author : jiang
 * @time : 2018/5/10 11:22
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("xxx.jpg");
        Image image2 = new ProxyImage("lalala.jpg");
        image.display();
        System.out.println("");
        image.display();
        System.out.println("");
        image2.display();

    }
}
