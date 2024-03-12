package org.example.bean.definition;

import org.example.bean.factory.DefaultUserFactory;
import org.example.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化 实现
 *
 * @author sleet
 * @version 2024-03-07
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(BeanInitializationDemo.class);
        // 启动容器
        applicationContext.refresh();
        System.out.println("Spring 容器已启动。。。");
        // 依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("Spring 容器准备关闭。。。");
        // 关闭容器
        applicationContext.close();
        System.out.println("Spring 容器已关闭。。。");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
//    @Lazy
    public UserFactory getUserFactory(){
        return new DefaultUserFactory();
    }
}
