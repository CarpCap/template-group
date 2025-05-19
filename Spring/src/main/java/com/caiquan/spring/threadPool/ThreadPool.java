package com.caiquan.spring.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/1911:50
 */
public class ThreadPool {
    public static ExecutorService es= Executors.newFixedThreadPool(10);
}
