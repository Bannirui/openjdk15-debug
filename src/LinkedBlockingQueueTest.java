import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dingrui
 * @since 2022/11/22
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        test00();
    }

    private static void test00() throws InterruptedException {
        LinkedBlockingQueue<Long> q = new LinkedBlockingQueue<>();
        q.put(1L);
        Long ans = q.take();
        System.out.println();
    }
}
