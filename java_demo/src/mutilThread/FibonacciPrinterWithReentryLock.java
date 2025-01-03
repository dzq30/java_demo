package mutilThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dzq
 * @Date 2025/1/3 15:22
 * @Description
 */
public class FibonacciPrinterWithReentryLock extends Thread {
    private static int n;
    private static int current = 0, next = 1;
    private static int toPrintThreadId = 0;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 0;


    private final int curThreadId;
    private int printCount = 0;

    FibonacciPrinterWithReentryLock(int curThreadId) {
        this.curThreadId = curThreadId;
    }

    public static void SetN(int n) {
        FibonacciPrinterWithReentryLock.n = n;
    }

    @Override
    public void run() {
        while (count < n) {
            lock.lock();
            while (curThreadId != toPrintThreadId) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (count >= n) return;
            int fib = current;
            current = next;
            next = fib + next;
            printCount++;
            System.out.println("Thread " + curThreadId + " printCount: " + printCount + " printed: " + fib);
            count++;
            toPrintThreadId = (toPrintThreadId + 1) % 3;
            condition.signalAll();
            lock.unlock();
        }
    }
}

class ReentryLockMain {
    public static void main(String[] args) {
        Thread thread1 = new FibonacciPrinterWithReentryLock(0);
        Thread thread2 = new FibonacciPrinterWithReentryLock(1);
        Thread thread3 = new FibonacciPrinterWithReentryLock(2);
        FibonacciPrinterWithReentryLock.SetN(30);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
