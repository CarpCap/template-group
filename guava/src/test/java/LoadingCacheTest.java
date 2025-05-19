import com.google.common.cache.*;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

/**
 * @author  CarpCap
 */
public class LoadingCacheTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<Integer,String> cacheMap = CacheBuilder.newBuilder().initialCapacity(10)
                .concurrencyLevel(10)
                .expireAfterAccess(Duration.ofSeconds(2))  //两秒缓存如果没有读写操作 就会失效
                .recordStats()
                .removalListener(new RemovalListener<Integer,String>(){
                    @Override
                    public void onRemoval(RemovalNotification<Integer, String> notification) {
                        System.out.println("缓存被移除"+notification.getValue());
                    }
                })
                .build(new CacheLoader<Integer,String>(){
                    @Override
                    public String load(Integer key) throws Exception {
                        //这里是缓存加载器  可以写sql
                        System.out.println("调用了一次");
                        return "data of database by id = "+ key;
                    }
                });
        System.out.println(cacheMap.get(1));
        System.out.println(cacheMap.get(1));
        System.out.println(cacheMap.get(2));

        //等待缓存过期 我们看看他会干什么
        Thread.sleep(3000L);
        System.out.println(cacheMap.get(1));

        //回收 key 1 缓存
        cacheMap.invalidate("k1");

        //回收所有缓存
        cacheMap.invalidateAll();


    }

    @Test
    public void modeUseObject() throws ExecutionException, InterruptedException {
        //模拟使用object对象 弱引用 会不会被指向null
        Cache<String,Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        cache.put("key1",value);

        value = new Object();//原对象不再有强引用
        System.gc();
        System.out.println(cache.getIfPresent("key1"));

    }
}
