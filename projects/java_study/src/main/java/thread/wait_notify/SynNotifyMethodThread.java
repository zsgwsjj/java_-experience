package thread.wait_notify;

/**
 * @author : jiang
 * @time : 2018/5/31 14:06
 */
public class SynNotifyMethodThread extends Thread {

    private Object lock;

    public SynNotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}
