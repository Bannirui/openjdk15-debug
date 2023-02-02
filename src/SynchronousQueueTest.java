import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author dingrui
 * @since 2022/11/22
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        test00();
    }

    private static void test00() throws InterruptedException, IOException {
        BlockingQueue<String> q = new SynchronousQueue<>();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.schedule(() -> {
            try {
                q.put("1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1_000, TimeUnit.MILLISECONDS);

        pool.schedule(() -> {
            try {
                q.put("2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 10_000, TimeUnit.MILLISECONDS);

        System.in.read();
    }

    private static void test01() throws InterruptedException {
        SynchronousQueue<String> q = new SynchronousQueue<>();
        q.take();
    }
}