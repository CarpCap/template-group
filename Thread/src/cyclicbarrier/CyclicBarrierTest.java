package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2021/1/3 17:22
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        CyclicBarrier barrier=new CyclicBarrier(10);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("同步输出");

            }).start();
            Thread.sleep(1000);
        }

    }
}
