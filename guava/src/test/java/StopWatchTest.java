import com.google.common.base.Stopwatch;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author  CarpCap
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0; i<2; i++){
            // do some thing
            Thread.sleep(1000);
        }
//        long nanos = stopwatch.elapsed().toMillis();
        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("逻辑代码运行耗时："+nanos);
    }
}
