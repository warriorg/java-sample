package me.warrior.common.json;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONMapperTest {

    @Test
    public void limit() throws IOException {
        List<Map<String, String>> mapList = new ArrayList<>(100000);
        int i = 0;
        while (i < 100000) {
            Map<String, String> map = new HashMap<>(5);
            map.put("name", "xxxx");
            map.put("age", "12");
            map.put("address", "xxxxxxxxxxxxxxxxxxxxx");
            map.put("job", "kdfjlsdjfksdjljdsljfkls");
            map.put("xdsf", "dfsdsfsdfsdfsdfsdf");
            map.put("name2", "xxxx");
            map.put("age3", "12");
            map.put("address4", "xxxxxxxxxxxxxxxxxxxxx");
            map.put("job5", "kdfjlsdjfksdjljdsljfkls");
            map.put("xdsf6", "dfsdsfsdfsdfsdfsdf"); map.put("address", "xxxxxxxxxxxxxxxxxxxxx");
            map.put("job2", "kdfjlsdjfksdjljdsljfkls");
            map.put("xdsf2", "dfsdsfsdfsdfsdfsdf");
            map.put("name22", "xxxx");
            mapList.add(map);
            i++;
        }

        String json = JSONMapper.toJSONString(mapList);
        System.out.println(json);

        List<Map<String, Object>> jsonList = JSONMapper.getInstance().fromJson(json, List.class);
        System.out.println(jsonList);
    }
}
