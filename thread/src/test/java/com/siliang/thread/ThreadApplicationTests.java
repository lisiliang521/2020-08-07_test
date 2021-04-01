package com.siliang.thread;

import com.siliang.thread.lock.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
class ThreadApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        A a = new A();
        long l = System.currentTimeMillis();
//      线程1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increase();
            }
        });
        t1.start();
//      主线程
        for (int i = 0; i < 1000000; i++) {
            a.increase();
        }
        t1.join();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(String.format("%sms",l1-l));
        System.out.println(a.getNum());
    }

}
