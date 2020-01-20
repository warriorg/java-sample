package me.warriorg.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author warrior
 */
public class ListToMapStream {

    static List<StreamApplication.User> users = Arrays.asList(
            new StreamApplication.User("C", 30),
            new StreamApplication.User("D", 40),
            new StreamApplication.User("A", 10),
            new StreamApplication.User("B", 20),
            new StreamApplication.User("A", 110),
            new StreamApplication.User("B", 200),
            new StreamApplication.User("E", 50));

    public static void main(String[] args) {
        Map<String, StreamApplication.User> map = users.stream().collect(Collectors.toMap(StreamApplication.User::getName, Function.identity(), (o, n) -> o));
        map.forEach((key, value) -> {
            System.out.println(key + value);
        });
    }
}
