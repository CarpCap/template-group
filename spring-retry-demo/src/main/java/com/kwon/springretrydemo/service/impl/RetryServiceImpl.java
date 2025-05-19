package com.kwon.springretrydemo.service.impl;

import com.kwon.springretrydemo.service.RetryService;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

/**
 * @author  CarpCap
 */
@Service
public class RetryServiceImpl implements RetryService {
    private static int count = 1;

    @Override
    public String retry() throws RuntimeException {
        System.out.println("retry{"+count+"},throw CustomRetryException in method retry");
        count ++;
        throw new RuntimeException("throw custom exception");
    }

    @Recover
    public String recover(Throwable throwable) {
        System.out.println("Default Retry service test");
        return "Error Class :: " + throwable.getClass().getName();
    }


}
