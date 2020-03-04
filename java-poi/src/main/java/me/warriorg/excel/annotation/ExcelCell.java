package me.warriorg.excel.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author warrior
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ExcelCell {

    /**
     * 列head
     */
    String title() default "";

    /**
     * 可空
     */
    boolean nullable() default true;

}
