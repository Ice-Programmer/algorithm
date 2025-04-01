package handwriting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEven {
    private static final Object lock = new Object();
    private static boolean isOddTurn = true; // 控制交替的标志
    private static final long MAX_NUM = 100;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // 奇数线程
        Thread oddThread = new Thread(() -> {

            while (counter.get() < MAX_NUM) {

                synchronized (lock) {
                    while (!isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ignore) {
                        }
                    }

                    // 生成随机奇数
                    int num = ThreadLocalRandom.current().nextInt(0, 1000);
                    if (num % 2 == 0) num++;
                    System.out.println("奇数线程: " + num);
                    counter.incrementAndGet();
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (counter.get() < MAX_NUM) {
                synchronized (lock) {
                    while (isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ignore) {
                        }
                    }
                    // 生成随机偶数
                    int num = ThreadLocalRandom.current().nextInt(0, 1000);
                    if (num % 2 != 0) num++;
                    System.out.println("偶数线程: " + num);
                    counter.incrementAndGet();
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}