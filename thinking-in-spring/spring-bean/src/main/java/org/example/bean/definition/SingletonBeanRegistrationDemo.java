package org.example.bean.definition;

import org.example.bean.factory.DefaultUserFactory;
import org.example.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册示例
 *
 * @author sleet
 * @version 2024-03-12
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册一个外部的 UserFactory 对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册外部单例对象
        beanFactory.registerSingleton("userFactory", userFactory);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找
        UserFactory userFactoryByLookupForBeanFactory = beanFactory.getBean("userFactory",UserFactory.class);
        UserFactory userFactoryByLookupForContext = applicationContext.getBean(UserFactory.class);

        System.out.println("userFactoryByLookupForBeanFactory == userFactory ？" + (userFactory == userFactoryByLookupForBeanFactory));
        System.out.println("userFactoryByLookupForContext == userFactory ？" + (userFactory == userFactoryByLookupForContext));

        // 关闭应用上下文
        applicationContext.close();
    }
}
