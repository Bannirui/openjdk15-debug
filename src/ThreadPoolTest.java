import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dingrui
 * @since 2022/11/20
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        test00();
    }

    private static void test00() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("task"));
    }
}
