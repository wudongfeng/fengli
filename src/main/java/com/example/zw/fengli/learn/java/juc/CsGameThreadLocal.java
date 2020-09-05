package com.example.zw.fengli.learn.java.juc;

import java.util.concurrent.ThreadLocalRandom;

public class CsGameThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 0;
    private static final Integer TOTAL_PLAYERS = 10;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }

    };

}
