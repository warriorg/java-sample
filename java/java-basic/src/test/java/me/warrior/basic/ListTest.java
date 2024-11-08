package me.warrior.basic;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {


    @Test
    void removeTest() {
        List<String> list = List.of("1", "1", "1");
        list.remove("1");

    }

}
