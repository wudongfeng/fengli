package com.example.zw.fengli.learn.java.limit;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @Author wudongfeng wudongfeng@baidu.com
 * @Date 2020/9/8 7:22 PM
 * @Version 0.0.1
 */
@Slf4j
public class Action {

    private RateLimiters rateLimiters;

    public Action() {
        rateLimiters = new RateLimiters(3);

    }

    public void doSomeThing() throws InterruptedException {
        try {
            rateLimiters.acquire(1);
            log.info("i begin do something");
            Thread.sleep(1000);
        } finally {
            rateLimiters.release(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Action action = new Action();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadList.add(new Thread(() -> {
                try {
                    action.doSomeThing();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }

        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }

}
