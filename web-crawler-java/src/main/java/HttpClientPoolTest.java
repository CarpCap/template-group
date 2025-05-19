import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

/**
 * @author  CarpCap
 * @Title:  httpClient连接池
 * @Description:
 * @date 2020/4/21 02:00
 */
public class HttpClientPoolTest {
    public static void main(String[] args) throws Exception {
        //创建连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        cm.setMaxTotal(50);
        //设置最大主机连接数，这指的是我爬取一个域名最大的连接数
        cm.setDefaultMaxPerRoute(10);

        doGet(cm);
    }
    public static void doGet(PoolingHttpClientConnectionManager cm) throws IOException {
        //获取连接
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        //发起请求
        CloseableHttpResponse response=httpClient.execute(httpGet);
        //关闭response
        response.close();

        //不需要关闭httpClient 因为连接池帮我们管理了

    };
}
