package org.example.ioc.overview.dependency.container;

import org.example.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} 作为IoC容器示例
 *
 * @author sleet
 * @version 2024-01-31
 */
public class AnnotationApplicationContextAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 Bean 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类作为配置类
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);
    }

    /**
     * 通过 java 注解配置一个 bean
     */
    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("sleet");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合对象：" + users);
        }
    }

}
