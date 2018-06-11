package thread.wait_notify;

/**
 * @author : jiang
 * @time : 2018/5/31 14:04
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }

}
