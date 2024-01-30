package org.example.sleet;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author sleet
 * @version 2024-01-25
 * @description
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String value = propertyDescriptor.getName();
                    if ("age".equals(value)) {
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditorSupport.class);
                    }
                });
        ;

    }

    static class StringToIntegerPropertyEditorSupport
            extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
