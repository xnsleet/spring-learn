package org.example.ioc.overview.dependency.injection;

import org.example.ioc.overview.dependency.domain.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入
 *
 * @author sleet
 * @version 2024-01-30
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        //依赖来源一：自定义 Bean
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");

        //依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());

        //依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment Bean"+environment);

        System.out.println(userRepository);

        System.out.println(userRepository.getBeanFactory() == beanFactory);

        System.out.println(userRepository.getUserObjectFactory().getObject());

        //依赖查找（错误代码）
//        System.out.println(beanFactory.getBean(BeanFactory.class));
    }
}
