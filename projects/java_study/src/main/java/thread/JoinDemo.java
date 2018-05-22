package thread;

/**
 * @author : jiang
 * @time : 2018/5/18 15:02
 */
public class JoinDemo extends Thread {

    private String name;

    public JoinDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始！");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行： " + i);
            try {
                sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束！");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        Thread thread1=new JoinDemo("A");
        Thread thread2=new JoinDemo("B");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("结束");

    }

}
