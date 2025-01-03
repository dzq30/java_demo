package mutilThread;

import java.util.concurrent.Semaphore;

/**
 * @author dzq
 * @Date 2025/1/3 16:28
 * @Description
 */
public class FibonacciPrinterWithSemaphore extends Thread {
    private static int n, count;
    private static int current, next = 1;
    private static int toPrintThreadId = 0;
    private static Semaphore[] semaphore = new Semaphore[3];

    static {
        for (int i = 0; i < 3; i++) {
            semaphore[i] = new Semaphore(0);
        }
        semaphore[0].release();
    }

    private final int curThreadId;
    private int printCount = 0;

    FibonacciPrinterWithSemaphore(int curThreadId) {
        this.curThreadId = curThreadId;
    }

    public static void SetN(int n) {
        FibonacciPrinterWithSemaphore.n = n;
    }

    @Override
    public void run() {
        while (count < n) {
            try {
                semaphore[curThreadId].acquire();
                if (count >= n) return;
                int fib = current;
                current = next;
                next = fib + current;
                printCount++;
                System.out.println("Thread " + curThreadId + " printCount: " + printCount + " printed: " + fib);
                count++;
                toPrintThreadId = (toPrintThreadId + 1) % 3;
                semaphore[toPrintThreadId].release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SemaphoreMain {
    public static void main(String[] args) {
        Thread thread1 = new FibonacciPrinterWithSemaphore(0);
        Thread thread2 = new FibonacciPrinterWithSemaphore(1);
        Thread thread3 = new FibonacciPrinterWithSemaphore(2);
        FibonacciPrinterWithSemaphore.SetN(30);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
