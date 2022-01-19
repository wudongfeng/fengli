package com.example.zw.fengli.learn.java.limit;

import com.google.common.util.concurrent.RateLimiter;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @Author wudongfeng wudongfeng@baidu.com
 * @Date 2020/9/8 7:52 PM
 * @Version 0.0.1
 */
@Slf4j
public class GuavaRateLimiterTest {
    /**
     * 每秒产生10哥令牌
     */
    private RateLimiter rateLimiter= RateLimiter.create(10);

    public void executerJob(){
        if(rateLimiter.tryAcquire()){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            log.info("线程{}执行业务成功",Thread.currentThread().getName());
        }else {
            log.info("线程{}获取锁失败",Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        GuavaRateLimiterTest guavaRateLimiterTest=new GuavaRateLimiterTest();
        Thread.sleep(5000);

        for(int i=0;i<100;i++){
            new Thread(guavaRateLimiterTest::executerJob).start();
        }
    }




}
