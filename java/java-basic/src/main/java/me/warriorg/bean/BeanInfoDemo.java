package me.warriorg.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * {@link java.beans.BeanInfo}
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        // BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        // 直输出当前类
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(it -> {
            // PropertyDescriptor 允许添加属性编辑器 PropertyEditor
            Class<?> propertyType = it.getPropertyType();
            String propertyName = it.getName();
            if ("age".equals(propertyName)) {
                // String -> Integer
                it.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                it.createPropertyEditor()
            }
            System.out.println(it);
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
           Integer integer = Integer.valueOf(text);
           setValue(integer);
        }
    }

}
