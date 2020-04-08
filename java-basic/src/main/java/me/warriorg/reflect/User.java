package me.warriorg.reflect;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Super {
    private String name;
    private String password;
}
