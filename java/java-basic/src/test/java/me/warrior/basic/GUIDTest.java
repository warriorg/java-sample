package me.warrior.basic;

import org.hibernate.id.UUIDGenerator;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class GUIDTest {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {

            // UUIDHexGenerator
            System.out.println(UUID.randomUUID().getMostSignificantBits());
        }
    }
}
