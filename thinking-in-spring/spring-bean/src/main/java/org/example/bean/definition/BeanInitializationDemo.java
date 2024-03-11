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
        // 依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        // 关闭容器
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    public UserFactory getUserFactory(){
        return new DefaultUserFactory();
    }
}
