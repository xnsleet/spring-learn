package org.example.bean.definition;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解 BeanDefinition 示例
 *
 * @author sleet
 * @version 2024-02-24
 */
//3.通过 @Import 导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 Bean 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class 配置类
        applicationContext.register(Config.class);

        // 启动应用上下文
        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);
        User sleetUser = applicationContext.getBean("sleetUser", User.class);
        System.out.println(user == sleetUser);

        // 通过 BeanDefinition 注册 API 方式实现
        registerBeanDefinition(applicationContext,"myUser", User.class);   //命名
        registerBeanDefinition(applicationContext,User.class);  //非命名

        System.out.println("Config Bean 所有实例：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User Bean 所有实例：" + applicationContext.getBeansOfType(User.class));

        // 显式的关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Component //2.通过 @Component 方式 作为 Spring 的组件
    public static class Config {

        //1.通过 @Bean 方式定义
        @Bean(name = {"user", "sleetUser"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("sleet");
            user.setAge(30);
            return user;
        }
    }

    /**
     * 命名 Bean 的方式注册
     *
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry,
                                              String beanName,
                                              Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "sleet")
                .addPropertyValue("age", 30);

        // 命名 Bean 的方式注册
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 的方式注册
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry,
                                              Class<?> beanClass){
        registerBeanDefinition(registry,null,beanClass);
    }
}
