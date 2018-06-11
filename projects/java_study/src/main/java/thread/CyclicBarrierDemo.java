package thread;

import java.util.Map;
import java.util.concurrent.*;

public class CyclicBarrierDemo implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> resultMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry entry : resultMap.entrySet()) {
            result = result + (Integer) entry.getValue();
        }
        resultMap.put(Thread.currentThread().getName(), result);
        System.out.println(resultMap);
    }

    public void calculate(){
        for (int i=0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    resultMap.put(Thread.currentThread().getName(),10);
                    System.out.println(Thread.currentThread().getName()+" is waiting");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" is working");
                }
            });
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierDemo().calculate();
    }
}
