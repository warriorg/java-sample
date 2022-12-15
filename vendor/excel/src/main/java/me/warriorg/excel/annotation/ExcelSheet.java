package me.warriorg.excel.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author warrior
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface ExcelSheet {
}
