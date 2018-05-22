package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 14:17
 */
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行 : " + i);
            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1=new ThreadDemo("A");
        Thread thread2=new ThreadDemo("B");

        thread1.start();
        thread2.start();
    }
}
