package me.warrior.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author 高士勇
 * @date
 */
public class JSONMapper {
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static class StaticSingletonHolder {
        private static final JSONMapper instance = new JSONMapper();
    }

    private ObjectMapper mapper;

    private JSONMapper() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 创建默认Mapper
     */
    public static JSONMapper getInstance() {
        return StaticSingletonHolder.instance;
    }

    /**
     * 对象转换成JSON字符串
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        try {
            return getInstance().mapper.writeValueAsString(object);
        }
        catch (IOException e) {
            logger.debug("toJson出错:" + object, e);
            return null;
        }
    }

    /**
     * JSON转换成Java对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T>  T fromJson(String json, Class<T> clazz) {
        if (json == null || json.trim().length() == 0) {
            return null;
        }

        try {
            return mapper.readValue(json, clazz);
        }
        catch (IOException e) {
            logger.warn("fromJson出错:" + json, e);
            return null;
        }
    }

    /**
     * 字符串转类数组
     *
     * @param json
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public <T> T fromJson(String json, TypeReference valueTypeRef) {
        if (json == null || json.trim().length() == 0) {
            return null;
        }
        try {
            return mapper.readValue(json, valueTypeRef);
        }
        catch (IOException e) {
            logger.warn("fromJson出错:" + json, e);
            return null;
        }
    }

    /**
     * JSON转换成Java对象
     *
     * @param json
     * @return
     */
    public HashMap<String, Object> json2Map(String json) {
        return fromJson(json, HashMap.class);
    }

    /**
     * 把object转出clazz对象， 比如POJO和Map互换，字符串转换成Date
     *
     * @param object 原对象
     * @param clazz  目标类型
     * @param <T>
     * @return
     */
    public <T> T convert(Object object, Class<T> clazz) {
        if (object == null) {
            return null;
        }

        return mapper.convertValue(object, clazz);
    }


    /**
     * 如果jsons 是数组格式，则挨个转换成clazz对象返回list，否则直接尝试转换成clazz对象返回list
     *
     * @param jsons
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> List<T> fromJsons(String jsons, Class<T> clazz) throws IOException {
        if (jsons == null || jsons.trim().length() == 0) {
            return Collections.EMPTY_LIST;
        }

        List<T> list = new ArrayList<>();

        JsonNode jsonNode = mapper.readTree(jsons);
        if (jsonNode.isArray()) {
            // 是数组
            for (JsonNode child : jsonNode) {
                list.add(mapper.treeToValue(child, clazz));
            }
        }
        else {
            //不是数组
            list.add(fromJson(jsons, clazz));
        }

        return list;
    }

    /**
     * Json对象节点转类数组
     *
     * @param node
     * @param cla
     * @param <T>
     * @return
     */
    public <T> List<T> nodeToOjb(JsonNode node, Class<T> cla) {
        List<T> list = new ArrayList<>();
        try {
            if (node.isArray()) {
                for (JsonNode child : node) {
                    list.add(mapper.treeToValue(child, cla));
                }
            }
            else {
                list.add(mapper.treeToValue(node, cla));
            }
        }
        catch (JsonProcessingException e) {
            logger.error("对象节点转换错误", e);
        }
        return list;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

}
