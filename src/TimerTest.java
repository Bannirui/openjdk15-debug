import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器.
 *
 * @author dingrui
 * @since 2023/3/4
 */
public class TimerTest {

    private class MyTask extends TimerTask {

        private static final String TASK_INFO = "this is my task.";

        @Override
        public void run() {
            System.out.println("Thread=" + Thread.currentThread().getName() + " , Task=" + TASK_INFO);
        }
    }

    public void test() {
        Timer timer = new Timer("my-timer", false);
        timer.scheduleAtFixedRate(new MyTask(), 0, 3_000);
    }

    public static void main(String[] args) throws IOException {
        new TimerTest().test();
        System.in.read();
    }
}
