import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {
    public static void main(String[] args) {
        Map map = new HashMap(1000);
        Integer one = 128;
        Integer two = 128;
        Executors.newCachedThreadPool();
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        // 向线程池提交任务
        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 2; x++) {
                        System.out.println(Thread.currentThread().getName() + ":" + x);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        // 关闭线程池
        threadPool.shutdown(); // 设置线程池的状态为SHUTDOWN，然后中断所有没有正在执行任务的线程
        // threadPool.shutdownNow(); // 设置线程池的状态为STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表，该方法要慎用，容易造成不可控的后果
    }
}