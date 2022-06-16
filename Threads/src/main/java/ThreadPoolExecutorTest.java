import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        test1();
        test2();
    }

    public static void test1() throws Exception {
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                2,
                5,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );
        //Future<Integer> future = service.submit(new CallableTask());
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().ints(0, (100)).limit(1).findFirst().getAsInt();
            }
        });

        TimeUnit.SECONDS.sleep(3);

        System.out.println("future is done?" + future.isDone());
        if (future.isDone()) {
            System.out.println("callableTask返回参数:" + future.get());
        }
        service.shutdown();
    }

    public static void test2() {
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                2,
                5,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );
        service.execute(() -> {
                    System.out.println(String.format("thread name:%s", Thread.currentThread().getName()));
                }
        );
        service.shutdown();
    }
    /*
    static class CallableTask implements Callable<Integer>{
        @Override
        public Integer call (){
            return ThreadLocalRandom.current().ints(0,(100)).limit(1).findFirst().getAsInt();
        }
    }*/
}
