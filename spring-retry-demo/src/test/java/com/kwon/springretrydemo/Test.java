package com.kwon.springretrydemo;

import com.kwon.springretrydemo.service.RetryService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author  CarpCap
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private RetryService retryService;


    @org.junit.jupiter.api.Test
    public void Test(){
        try {
            System.out.println(retryService.retry());
        }catch (RuntimeException e){
            System.out.println("exce: " + e.getMessage());
        }
    }
}
