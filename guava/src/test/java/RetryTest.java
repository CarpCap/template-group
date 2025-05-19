import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author  CarpCap
 */
public class RetryTest {
    public static void main(String[] args) throws ExecutionException, RetryException {
        Retryer<String> retryer = RetryerBuilder.<String>newBuilder()
                .retryIfException() //发送异常则重试
                .retryIfResult(Predicates.equalTo("didi")) //对返回的结果判断，是否 重试   为“didi” 就重试
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS)) //重试间隔1秒
                .withStopStrategy(StopStrategies.stopAfterAttempt(5)) //停止策略 最多5次 然后抛出异常
                .build();
        //Retryer调用
        try {
            String call = retryer.call(() -> {
                System.out.println(Thread.currentThread().getName());
                return "didi";
            });
        }catch (RetryException e){
            //重试失败了 如果处理
            System.out.println("重试失败后处理");
        }


    }
}
