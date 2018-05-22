package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 14:29
 */
public class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行 ：" + i);
            try {
                Thread.sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadDemo("A").start();
        new ThreadDemo("B").start();
    }
}
