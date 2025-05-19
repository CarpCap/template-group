import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URISyntaxException;

/**
 * @author  CarpCap
 * @Title: get
 * @Description:
 * @date 2020/4/21 00:46
 */
public class HttpGetTest {
    public static void main(String[] args) throws Exception {
        //创建httpclient对象
        CloseableHttpClient  httpclient = HttpClients.createDefault();

        //设置请求地址，创建URIBulder
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s");


        //set 参数
        uriBuilder.setParameter("wd","java");

        //创建httpget对象
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

        System.out.println("请求的内容"+httpGet);

        //httpclient配置
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //创建连接最长时间，单位毫秒
            .setConnectionRequestTimeout(500)  //设置获取连接的最长时间
            .setSocketTimeout(10*1000)   //设置数据传输的最长时间 ，单位是毫秒
            .build();

        httpGet.setConfig(config);

        //请求 获取response
        CloseableHttpResponse response = httpclient.execute(httpGet);

        //解析响应
        if(response.getStatusLine().getStatusCode()==200){
            //解析编码
            String context = EntityUtils.toString(response.getEntity(),"utf8");
            System.out.println("响应长度"+context.length());

        }
    }
}
