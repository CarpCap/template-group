package jsoup;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/4/21 05:05
 */
public class JsoupTest {
    @Test
    public void domTest() throws Exception {
        //创建httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //设置请求地址，创建URIBulder
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com");


//        //set 参数
//        uriBuilder.setParameter("wd","java");

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

        String context=null;
        //解析响应
        if(response.getStatusLine().getStatusCode()==200){
            //解析编码
            context = EntityUtils.toString(response.getEntity(),"utf8");
            System.out.println("响应长度"+context.length());

        }


        Document doc= Jsoup.parse(context);
        Element element=doc.getElementById("mCon");
        System.out.println(element.text());

    }
}
