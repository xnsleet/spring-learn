package org.example.bean.definition;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 *
 * @author sleet
 * @version 2024-02-23
 */
public class BeanDefinitionCreatingDemo {
    public static void main(String[] args) {

        // 1. 通过BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();

        // 通过属性赋值
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("name", "sleet")
                .addPropertyValue("age", 30);

        // 获取 BeanDefinition 实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非 Bean 终态，可以自定义修改
        System.out.println(beanDefinition.getPropertyValues());

        // 2.通过AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);

        // MutablePropertyValues 批量设置属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

        // 设置属性方式1
        mutablePropertyValues.addPropertyValue("id", 1);
        mutablePropertyValues.addPropertyValue("name", "sleet");
        mutablePropertyValues.addPropertyValue("age", 30);

        // 设置属性方式2
        mutablePropertyValues.add("id", 2)
                .add("name", "sleet_copy")
                .add("age", 31);

        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}
