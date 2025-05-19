package com.kwon.springretrydemo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

/**
 * @author  CarpCap
 */
public interface RetryService {


    /**
     * 指定 RuntimeException异常进行重试 重试最大次数为4（默认是3）这个方法最多被调用4次 不能为0,重试补偿机制间隔200毫秒
     *
     * @param
     * @return
     * @author  CarpCap
     * @date 2022/7/14 13:43
     */
    @Retryable(value = {RuntimeException.class},maxAttempts = 4,backoff = @Backoff(200))
    String retry() throws RuntimeException;
}
