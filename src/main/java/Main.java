import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    static final int THREADS_QUANTITY = 5;

    public static void main(String[] args) {
        Queue<String> calls = new ConcurrentLinkedQueue<>();
        Runnable atc = new ATC(calls);
        new Thread(atc).start();

        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_QUANTITY);
        for (int i = 0; i < THREADS_QUANTITY; i++) {
            Specialist specialist = new Specialist("" + (i + 1) + "", calls);
            threadPool.submit(specialist);

        }
        threadPool.shutdown();
    }
}
