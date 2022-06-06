import java.util.Queue;
import java.util.Random;

public class ATC implements Runnable {

    private Queue<String> calls;
    private static final int CALLS_QUANTITY = 60;
    private Random random = new Random();

    public ATC(Queue<String> calls) {
        this.calls = calls;
    }

    @Override
    public void run() {
        for (int i = 0; i < CALLS_QUANTITY; i++) {
            calls.add("+79" + random.nextInt(1_000_000_000, 2_000_000_000));
        }
    }
}
