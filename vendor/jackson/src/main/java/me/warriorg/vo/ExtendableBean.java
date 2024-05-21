package me.warriorg.vo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

@Data
public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public ExtendableBean() {
        this.properties = new HashMap<>();
    }

    public ExtendableBean(String name) {
        this();
        this.name = name;
    }

    @JsonAnySetter
    public void add(String key, String value) {
        this.properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
