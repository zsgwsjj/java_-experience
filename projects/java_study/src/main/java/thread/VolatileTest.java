package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/5/30 18:41
 */
public class VolatileTest implements Runnable {

    private int n = 0;


    @Override
    public void run() {
        System.out.println(n++);
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(v));
        }
    }

}
