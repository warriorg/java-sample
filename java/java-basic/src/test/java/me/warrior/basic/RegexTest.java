package me.warrior.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gao shiyong
 * @date 2022/3/2 16:12
 */
public class RegexTest {

    @Test
    public void test() {
        Pattern PROXY_PATTERN = Pattern.compile("(https)://(.*):(.*)");

        Matcher matcher = PROXY_PATTERN.matcher("https://192.168.2.34:33344");
        Assertions.assertNotNull(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));

    }
}
