package thread;

import design_pattern.decorator.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CountLatchDemo implements Runnable {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);


    @Override
    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println("done first");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("done second");
            }
        });
        thread1.start();
        thread2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done all!");
    }

    public static void main(String[] args) {
        new Thread(new CountLatchDemo()).start();
    }
}

