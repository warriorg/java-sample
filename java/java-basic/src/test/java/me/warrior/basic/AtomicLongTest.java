package me.warrior.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gao shiyong
 * @since 2022/7/25 09:32
 */
public class AtomicLongTest {

    @Test
    public void addTest() {
        AtomicLong atomicLong = new AtomicLong();
        Assertions.assertEquals(0, atomicLong.get());
        atomicLong.addAndGet(10);
        atomicLong.addAndGet(10);
        Assertions.assertEquals(20, atomicLong.get());
        atomicLong.addAndGet(-10);
        Assertions.assertEquals(10, atomicLong.get());
        atomicLong.set(30);
        Assertions.assertEquals(30, atomicLong.get());
    }
}
