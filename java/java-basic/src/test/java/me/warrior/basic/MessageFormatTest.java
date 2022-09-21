package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

/**
 * @author gao shiyong
 * @since 2022/9/13 14:37
 */
public class MessageFormatTest {

    @Test
    public void test() {
        System.out.println(MessageFormat.format("Bearer {0}", "xxxxx"));
    }

}
