package mutilThread;

/**
 * @author dzq
 * @Date 2025/1/3 14:39
 * @Description
 */
public class FibonacciPrinterWithSync extends Thread {
    private static int n, count;
    private static int toPrintThreadId = 0;
    private static int current, next = 1;

    private int printCount = 0;
    private final int curThreadId;

    public FibonacciPrinterWithSync(int curThreadId) {
        this.curThreadId = curThreadId;
    }

    public static void SetN(int n) {
        FibonacciPrinterWithSync.n = n;
    }

    @Override
    public void run() {
        while (count < n) {
            synchronized (FibonacciPrinterWithSync.class) {
                while (curThreadId != toPrintThreadId) {
                    try {
                        FibonacciPrinterWithSync.class.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count >= n) return;
                int fib = current;
                current = next;
                next = fib + current;
                printCount++;
                System.out.println("Thread " + curThreadId + " printCount: " + printCount + " printed: " + fib);
                count++;
                toPrintThreadId = (toPrintThreadId + 1) % 3;
                FibonacciPrinterWithSync.class.notifyAll();
            }
        }
    }
}

class SyncMain {
    public static void main(String[] args) {
        Thread thread1 = new FibonacciPrinterWithSync(0);
        Thread thread2 = new FibonacciPrinterWithSync(1);
        Thread thread3 = new FibonacciPrinterWithSync(2);
        FibonacciPrinterWithSync.SetN(30);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

