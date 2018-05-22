package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 18:51
 */
public class MyThread implements Runnable {

    private String name;

    public MyThread setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("xxx");
        Thread thread1 = new Thread(thread);
        thread1.start();
    }
}
