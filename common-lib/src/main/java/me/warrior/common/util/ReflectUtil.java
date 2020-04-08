package me.warrior.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReflectUtil {

    /***
     *
     * @param type
     * @return
     */
    public static List<Field> getAllDeclaredFields(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }


    /***
     *
     * @param type
     * @return
     */
    public static Map<String, Field> getDeclaredFieldMap(Class<?> type) {
        List<Field> fieldList = getAllDeclaredFields(type);
        return fieldList.stream().collect(Collectors.toMap(Field::getName, Function.identity(), (oldVal, newVal) -> oldVal));
    }

}
