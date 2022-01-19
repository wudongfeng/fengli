package com.example.zw.fengli.learn.java.limit;

/**
 * Description:
 * 基于固定窗口的限流，特定的时间限定特定的数量
 *
 * @Author wudongfeng wudongfeng@baidu.com
 * @Date 2020/9/8 7:29 PM
 * @Version 0.0.1
 */
public class RateLimiterCount {
    private Long updateTimeStamp;
    private Integer intervalMilliSeconds;
    private Integer maxPermits;
    private Long storePermits;

    public RateLimiterCount(Integer maxPermits, Integer intervalMilliSeconds) {
        this.maxPermits = maxPermits;
        this.intervalMilliSeconds = intervalMilliSeconds;
    }

    public boolean acquire() {
        while (true) {
            Long now = System.currentTimeMillis();
            if (now < updateTimeStamp + intervalMilliSeconds) {
                if (storePermits + 1 <= maxPermits) {
                    storePermits++;
                    updateTimeStamp = now;
                    return true;
                } else {
                    return false;
                }

            } else {
                storePermits = 0L;
                updateTimeStamp = now;
            }
        }

    }

}
