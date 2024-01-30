package org.example.ioc.overview.dependency.injection;

import org.example.ioc.overview.dependency.domain.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author sleet
 * @version 2024-01-30
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        System.out.println(beanFactory);

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");

        System.out.println(userRepository);

        System.out.println(userRepository.getBeanFactory() == beanFactory);

        //依赖注入
        System.out.println(userRepository.getBeanFactory());

        System.out.println(userRepository.getUserObjectFactory().getObject());

        //依赖查找（错误代码）
//        System.out.println(beanFactory.getBean(BeanFactory.class));
    }
}
