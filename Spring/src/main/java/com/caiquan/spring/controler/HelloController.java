package com.caiquan.spring.controler;

import com.caiquan.spring.controler.face.HelloControllerFace;
import com.caiquan.spring.controler.face.HelloControllerFace2;
import com.caiquan.spring.dto.TestDto;
import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.service.Impl.HelloServiceImpl;
import com.caiquan.spring.service.WorkService;
import com.caiquan.spring.threadPool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@RestController()
@Scope("prototype")
public class HelloController implements HelloControllerFace2 {
    @Autowired
    HelloService helloServiceImpl;

    @Autowired
    WorkService workService;

    @Override
    public String hello(){
        return helloServiceImpl.hello();
    }

    @Override
    public String test(@PathVariable("value")String value){
        return value;
    }

    @GetMapping("hello")
    public int hello(TestDto testDto, HttpServletResponse response, HttpServletRequest request){
        return helloServiceImpl.hashCode();
    }

    @GetMapping("test")
    public String testet(TestDto testDto, HttpServletResponse response, HttpServletRequest request){
        System.out.println(testDto.getTestValue());
        return testDto.getTestValue();
    }

    @GetMapping("testAopClass")
    public String testAopClass(TestDto testDto, HttpServletResponse response, HttpServletRequest request){
        HelloServiceImpl helloService = new HelloServiceImpl();
        System.out.println(helloServiceImpl.hello());
        System.out.println(helloService.getClass().toString());
        System.out.println(helloServiceImpl.getClass());
        return "";
    }

    @GetMapping("testHandler")
    public String testHandler(TestDto testDto, HttpServletResponse response, HttpServletRequest request){
        // Handler不会在下一次访问同域名传输
        response.addHeader("test","testtestest");
        // Http 会返回一个 response 叫做 set-Cookie ，只有cookie浏览器才会携带记录 并且请求同域名时传输
        response.addCookie(new Cookie("2","3"));
        return "";
    }


//    @Autowired
//    public void testAuto() throws InterruptedException {
//        ThreadPool.es.submit(()->{
//            System.out.println("测试自动11111");
//            System.out.println(workService.test());
//            try {
//                Thread.sleep(223000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//    }

}
