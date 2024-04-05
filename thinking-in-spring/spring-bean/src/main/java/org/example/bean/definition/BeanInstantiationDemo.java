package org.example.bean.definition;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实例化示例
 *
 * @author sleet
 * @version 2024-03-05
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User staticUser = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println("user-by-static-method" + staticUser);

        User instantiationUser = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println("user-by-instance-method" + instantiationUser);

        User factoryUser = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println("user-by-factory-bean" + factoryUser);
     }
}
