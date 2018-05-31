package thread.wait_notify;

/**
 * @author : jiang
 * @time : 2018/5/31 14:07
 */
public class TestClass {

    public static void main(String[] args) {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();


        SynNotifyMethodThread b = new SynNotifyMethodThread(lock);
        b.start();

    }
}
