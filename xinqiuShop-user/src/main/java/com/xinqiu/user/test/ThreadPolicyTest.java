package com.xinqiu.user.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 拒绝策略
 */
public class ThreadPolicyTest {
    private static final Logger log = LoggerFactory.getLogger(ThreadPolicyTest.class);

    public static void main(String[] args) throws Exception{
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 5;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, handler);
        for(int i=0; i<100; i++) {
            try {
                executor.execute(new Thread(() -> log.info(Thread.currentThread().getName() + " is running")));
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
        }
        executor.shutdown();
    }
}
