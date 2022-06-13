import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    static final int THREADS_QUANTITY = 5;
    static final int WORKING_WITH_CLIENT = 4000;

    public static void main(String[] args) throws InterruptedException {
        Queue<String> calls = new ConcurrentLinkedQueue<>();
        Runnable atc = new ATC(calls);
        new Thread(atc).start();

        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_QUANTITY);
        for (int i = 0; i < THREADS_QUANTITY; i++) {
            Specialist specialist = new Specialist("" + (i + 1) + "", calls);
            threadPool.submit(specialist);
            Thread.sleep(WORKING_WITH_CLIENT);

        }
        threadPool.shutdown();
    }
}
