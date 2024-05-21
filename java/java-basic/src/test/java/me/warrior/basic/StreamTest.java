package me.warrior.basic;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamTest {

    @Test
    void givenMap_whenCount_thenSize() {
        // map 中的方法不执行
        System.out.println(Stream.of("1", "3", "4").map(it -> {
            System.out.println("xxxxxx");
            return null;
        }).count());
    }
}
