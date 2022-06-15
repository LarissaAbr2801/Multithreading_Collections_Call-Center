import java.util.Queue;

public class Specialist implements Runnable {

    private String name;
    private Queue<String> calls;
    private static final int WORKING_WITH_CLIENT = 3000;

    public Specialist(String name, Queue<String> calls) {
        this.name = name;
        this.calls = calls;
    }


    @Override
    public void run() {
        while (!calls.isEmpty()) {
            System.out.println("Специалист " + name + " работает с номером " + calls.poll());
            try {
                Thread.sleep(WORKING_WITH_CLIENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
