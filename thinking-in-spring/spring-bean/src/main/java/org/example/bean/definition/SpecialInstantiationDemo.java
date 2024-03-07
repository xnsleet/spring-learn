package org.example.bean.definition;

import org.example.bean.factory.DefaultUserFactory;
import org.example.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊实例化实现
 *
 * @author sleet
 * @version 2024-03-05
 */
public class SpecialInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        // 通过 AutowireCapableBeanFactory 实现
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        DefaultUserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);

        System.out.println(userFactory.createUser());

        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);

        demoServiceLoader();
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader =
                ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().createUser());
        }
    }
}
