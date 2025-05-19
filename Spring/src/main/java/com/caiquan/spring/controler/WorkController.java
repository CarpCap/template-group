package com.caiquan.spring.controler;

import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.threadPool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    HelloService helloServiceImpl;

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return helloServiceImpl.hello();
    }

    @PostMapping("test/{value}/add")
    @ResponseBody
    public String test(@PathVariable("value") String value){
        return value;
    }

//    @Autowired
//    public void testAuto()  {
//        ThreadPool.es.submit(()->{
//            System.out.println("测试自动");
//            System.out.println(helloServiceImpl.hello());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }

}
