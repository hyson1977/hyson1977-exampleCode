import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(String.format("test %s", "test"));
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("test");
            return "12345";
        });
        System.out.println(future.get());
    }
}
