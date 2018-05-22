package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 16:45
 */
public class NotifyDemo extends Thread {

    private String name;
    private Object prev;
    private Object self;

    public NotifyDemo(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        NotifyDemo notifyDemo1 = new NotifyDemo("A", c, a);
        NotifyDemo notifyDemo2 = new NotifyDemo("B", a, b);
        NotifyDemo notifyDemo3 = new NotifyDemo("C", b, c);

        new Thread(notifyDemo1).start();
        Thread.sleep(100);
        new Thread(notifyDemo2).start();
        Thread.sleep(100);
        new Thread(notifyDemo3).start();
        Thread.sleep(100);
    }
}
