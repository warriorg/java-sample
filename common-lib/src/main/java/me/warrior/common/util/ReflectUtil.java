package me.warrior.common.util;

import java.lang.reflect.Field;
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
     *
     * @param type
     * @return
     */
    public static Map<String, Field> getDeclaredFieldMap(Class<?> type) {
        List<Field> fieldList = getAllDeclaredFields(type);
        return fieldList.stream().collect(Collectors.toMap(Field::getName, Function.identity(), (oldVal, newVal) -> oldVal));
    }

    /***
     *
     *
     * @param type
     * @return
     */
    public static Map<String, Field> getDeclaredFieldMapKeyLower(Class<?> type) {
        List<Field> fieldList = getAllDeclaredFields(type);
        return fieldList.stream().collect(Collectors.toMap(key -> key.getName().toLowerCase(), Function.identity(), (oldVal, newVal) -> oldVal));
    }

    /***
     * 判断对象是否是某个超类的子类
     *
     * @param clazz
     * @param superClass
     * @return
     */
    public static boolean isSubclassOf(Class<?> clazz, Class<?> superClass) {
        if (superClass.equals(Object.class)) {
            // Every class is an Object.
            return true;
        }
        if (clazz.equals(superClass)) {
            return true;
        } else {
            clazz = clazz.getSuperclass();
            // every class is Object, but superClass is below Object
            if (clazz == null || clazz.equals(Object.class)) {
                // we've reached the top of the hierarchy, but superClass couldn't be found.
                return false;
            }
            // try the next level up the hierarchy.
            return isSubclassOf(clazz, superClass);
        }
    }

}
