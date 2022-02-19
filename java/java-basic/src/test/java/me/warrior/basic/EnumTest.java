package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EnumTest {

    public enum KindEnum {
        JUSTICE("公正", "0.1"),
        EVIDENCE("存证", "0.1");

        private String value;
        private String version;

        KindEnum(String value, String version) {
            this.value = value;
            this.version = version;
        }

        public static KindEnum parse(String name) {
            return Arrays.stream(KindEnum.values()).filter(m -> m.name().equals(name)).findAny().orElse(null);
        }
    }

    @Test
    public void enumTest() {
        for (KindEnum value : KindEnum.values()) {
            System.out.println(value.value);
            System.out.println(value.name());
            System.out.println(value.ordinal());
        }
        KindEnum kindEnum = KindEnum.parse("JUSTICE1");
        System.out.println(kindEnum);

    }
}
