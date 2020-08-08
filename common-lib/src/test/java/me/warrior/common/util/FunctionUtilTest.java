package me.warrior.common.util;

import me.warrior.common.model.People;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionUtilTest {

    @Test
    public void distinctByKeyTest() {
        People a = new People(28, "M", "Mr A", null);
        People b = new People(25, "M", "Mr B", null);
        People c = new People(21, "M", "Mr B", null);
        People d = new People(21, "M", "Mr B", null);
        Collection<People> list = Arrays.asList(a, b, c, d);

        // Get distinct only
        List<People> distinctElements = list.stream().filter(FunctionUtil.distinctByKey(p -> p.getName()))
                .collect(Collectors.toList());

        // print the distinct result
        System.out.println(distinctElements);

        // Get distinct with multiple keys
        List<People> distinctMultiKeys = list.stream().filter(FunctionUtil.distinctByKey(p -> p.getName() + p.getAge()))
                .collect(Collectors.toList());

        // print the distinct result
        System.out.println(distinctMultiKeys);
    }


}
