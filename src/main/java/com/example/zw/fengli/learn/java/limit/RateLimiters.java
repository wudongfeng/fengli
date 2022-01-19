package com.example.zw.fengli.learn.java.limit;

import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @Author wudongfeng wudongfeng@baidu.com
 * @Date 2020/9/8 7:19 PM
 * @Version 0.0.1
 */
public class RateLimiters {
    private Semaphore semaphore;

    public RateLimiters(int permits) {
        semaphore = new Semaphore(permits);
    }

    public void acquire(int permits) throws InterruptedException {
        semaphore.acquire();
    }

    public void release(int permits) {
        semaphore.release();
    }
}
