package org.example.bean.definition;

import org.example.ioc.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author sleet
 * @version 2024-02-24
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-alias-context.xml");
        User user = applicationContext.getBean("user", User.class);
        User sleetUser = applicationContext.getBean("sleet-user", User.class);

        System.out.println("设置别名和原始名称 Bean 是否相同："+(user == sleetUser));
    }
}
