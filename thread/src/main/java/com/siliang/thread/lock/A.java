package com.siliang.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class A {

    int num = 0;


//    public synchronized void increase() {
//        num++;
//    }
AtomicInteger atomicInteger = new AtomicInteger();
    public long getNum() {
        return atomicInteger.get();
    }
    public void increase() {
        atomicInteger.incrementAndGet();
    }
}
