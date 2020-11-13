package me.warriorg.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.warriorg.model.JsonModel;
import me.warriorg.model.UserNaming;

import java.lang.reflect.Field;

public class GsonApplication {

    public static void main(String[] args) {

        JsonModel obj = JsonModel.builderJsonMode();
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));

        System.out.println("IDENTITY-----------");
        testPolicy(FieldNamingPolicy.IDENTITY);

        System.out.println("LOWER_CASE_WITH_UNDERSCORES-----------");
        testPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        System.out.println("LOWER_CASE_WITH_DASHES-----------");
        testPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES);

        System.out.println("UPPER_CAMEL_CASE-----------");
        testPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);

        System.out.println("UPPER_CAMEL_CASE_WITH_SPACES-----------");
        testPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES);

        System.out.println("Custom-----------");
        customPolicy();
    }

    private static void testPolicy (FieldNamingPolicy policy) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(policy);
        Gson gson = gsonBuilder.create();

        UserNaming user = new UserNaming("Norman", "norman@futurestud.io", true, 26, "a", "b", "d");
        String usersJson = gson.toJson(user);
        System.out.println(usersJson);
    }

    private static void customPolicy() {
        FieldNamingStrategy customPolicy = new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                return f.getName().replace("_", "");
            }
        };

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingStrategy(customPolicy);
        Gson gson = gsonBuilder.create();

        UserNaming user = new UserNaming("Norman", "norman@futurestud.io", true, 26, "a", "b", "d");
        String usersJson = gson.toJson(user);
        System.out.println(usersJson);
    }
}
