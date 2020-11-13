package me.warriorg.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.warriorg.model.JsonModel;

public class JacksonApplication {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonModel obj = JsonModel.builderJsonMode();

        String jsonInString = mapper.writeValueAsString(obj);
        System.out.println(jsonInString);

        test();
    }

    public static void test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.USE_STD_BEAN_NAMING, true);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        JsonModel obj = JsonModel.builderJsonMode();

        String jsonInString = mapper.writeValueAsString(obj);
        System.out.println(jsonInString);
    }



}
