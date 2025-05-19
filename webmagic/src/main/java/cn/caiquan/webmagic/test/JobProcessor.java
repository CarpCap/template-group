package cn.caiquan.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

import java.util.List;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/4/25 02:18
 */
public class JobProcessor implements PageProcessor {

    //解析页面
    public void process(Page page) {
        List<String> all = page.getHtml().css("ul#navitems-group1").links().all();
        if(all.size()!=0){
            page.addTargetRequests(all);
        }else {
            System.out.println(page.getHtml().toString());
            page.putField("1",page);
        }



//        //css
//        page.putField("div",page.getHtml().css("ul#navitems-group1 li a").get());
//
//        //Xpath
//        page.putField("div2",page.getHtml().xpath("//div[@id=news_div]/ul/li/div/a"));
//
//        //正则表达式
//        page.putField("div3",page.getHtml().css("dev#news_div a").regex(".*江苏.*").all());

    }

    Site site=Site.me().addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1 Safari/605.1.15");
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://www.jd.com")   //设置爬取页面
                .setScheduler(new FileCacheQueueScheduler("/Users/CarpCap/data/scheduler"))
                .thread(2)
                .run(); //执行
    }
}
