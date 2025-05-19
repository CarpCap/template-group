package CompletableFuture;

import java.util.concurrent.*;

/**
 * @author  CarpCap
 */
public class CompletableFutureTest {




    public static void main(String[] args) throws Exception {
//        submitTest();
        test2();
//        test4();
    }


    /**
     * 子线程是异步执行的，主线程休眠等待子线程执行完成，子线程执行完成后唤醒主线程，主线程获取任务执行结果后退出。
     *
     * 很多博客说使用不带等待时间限制的get方法时，如果子线程执行异常了会导致主线程长期阻塞，这其实是错误的，子线程执行异常时其异常会被捕获，然后修改任务的状态为异常结束并唤醒等待的主线程，get方法判断任务状态发生变更，就终止等待了，并抛出异常，可参考《Java8 AbstractExecutorService 和 FutureTask 源码解析》中FutureTask的实现。将上述用例中if(false)改成if(true) ，执行结果如下：
     * ————————————————
     * 版权声明：本文为CSDN博主「孙大圣666」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_31865983/article/details/106137777
     *
     * @param
     * @return
     * @author  CarpCap
     * @date 2022/6/27 15:20
     */
    public static  void submitTest() throws ExecutionException, InterruptedException {
        // 创建异步执行任务:
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    public static void test2() throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);

                System.out.println("job1 thread name :"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        },pool);
        //cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
        //thenApply这里实际创建了一个新的CompletableFuture实例
        CompletableFuture<String> cf2=cf.thenApply((result)->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
                System.out.println("job2 thread name :"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return "test:"+result;
        });
        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        //就算不调用get方法 cf的返回值也会交给 thenApply内部代码执行
        System.out.println("run result->"+cf.get());
        System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());

    }


}
