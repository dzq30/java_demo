package mutilThread;

/**
 * @author dzq
 * @Date 2025/1/3 14:39
 * @Description
 */
public class FibonacciPrinterWithSync extends Thread {
    int currentThreadId; // 当前应该打印的线程id
    int fib, current, next; // fib相关参数
    int n, count; // 要打印的总数、已打印的个数

    public FibonacciPrinterWithSync(int n) {
        this.n = n;
        this.next = 1;
        this.fib = this.current = this.count = 0;
    }

    public synchronized void printFibonacci(int threadId) {
        while (count <= n) {
            while (threadId != currentThreadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            fib = current;
            current = next;
            next = fib + current;
            System.out.println("threadId = " + (threadId + 1) + ", fib = " + fib);
            currentThreadId = (currentThreadId + 1) % 3;
            count++;
            notifyAll();
        }
    }

    @Override
    public void run() {
        super.run();
    }

    /**
     * @author dzq
     * @Date 2025/1/3 15:28
     * @Description
     */
    static class SyncMain {
        public static void main(String[] args) {
            //test multiThread();
            FibonacciPrinterWithSync fibonacciPrinter = new FibonacciPrinterWithSync(15);
            Thread thread1 = new Thread(() -> {
                fibonacciPrinter.printFibonacci(0);
            });
            Thread thread2 = new Thread(() -> {
                fibonacciPrinter.printFibonacci(1);
            });
            Thread thread3 = new Thread(() -> {
                fibonacciPrinter.printFibonacci(2);
            });
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}

