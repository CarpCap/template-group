import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author  CarpCap
 */
public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");
        System.out.println("get one permit cost time: " + limiter.acquire(1) + "s");

    }
}
