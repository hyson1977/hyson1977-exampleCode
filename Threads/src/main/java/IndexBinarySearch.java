import java.util.concurrent.*;

public class IndexBinarySearch<T> {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5, 10,
                20,
                TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>()
                //new LinkedBlockingDeque<Runnable>(2)

        );

//        List<Runnable> rlist=new ArrayList<>();
//        for(int i=0;i<30;i++){
//            rlist.add(new RunnableTest(poolExecutor));
//        }
//        for(int i=0;i<30;i++){
//            poolExecutor.execute(rlist.get(1));
//        }

        for(int i=0;i<40;i++){
            poolExecutor.execute(new RunnableTest(poolExecutor,i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        poolExecutor.shutdown();
    }
}

class RunnableTest implements Runnable{

    ThreadPoolExecutor poolExecutor;
    private int num;

    public RunnableTest(  ThreadPoolExecutor poolExecutor ,int num){
        this.poolExecutor=poolExecutor;
        this.num=num;
    }

    @Override
    public void run() {
        int threadSize=this.poolExecutor.getActiveCount();
        int queueCurrentSize=this.poolExecutor.getQueue().size();
        System.out.println(Thread.currentThread().getName()+":执行开始："+"当前线程数："+threadSize+"当前队列大小："+queueCurrentSize+" , currentid:"+num);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
