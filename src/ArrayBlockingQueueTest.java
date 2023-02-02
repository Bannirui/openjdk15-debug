import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author dingrui
 * @since 2022/11/22
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        test00();
    }

    private static void test00() throws InterruptedException {
        BlockingQueue<Long> q = new ArrayBlockingQueue<>(1);
        q.put(1L);
        q.put(2L);
        Long ans = q.take();
    }
}
