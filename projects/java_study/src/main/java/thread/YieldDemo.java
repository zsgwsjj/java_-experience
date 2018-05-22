package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 15:44
 */
public class YieldDemo extends Thread {

    public YieldDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(this.getName() + "----- " + i);
            if (i == 30) {
                yield();
            }
        }
    }

    public static void main(String[] args) {
        new YieldDemo("A").start();
        new YieldDemo("B").start();
    }
}
