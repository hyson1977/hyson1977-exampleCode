import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class SmallTool {
    public static void sleepMillis(long millis) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add((Thread.currentThread().getName()))
                .add(tag)
                .toString();
        System.out.println(result);
    }
}
