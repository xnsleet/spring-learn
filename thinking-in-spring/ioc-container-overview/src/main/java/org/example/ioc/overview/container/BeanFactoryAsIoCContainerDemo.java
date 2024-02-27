package org.example.ioc.overview.container;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link org.springframework.beans.factory.BeanFactory} 作为IoC容器
 *
 * @author sleet
 * @version 2024-02-23
 */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 Bean 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // XML文件地址 classpath 路径
        String classpath = "classpath:META-INF/dependency-lookup-context.xml";
        int loadBeanDefinitionsCount = xmlBeanDefinitionReader.loadBeanDefinitions(classpath);
        System.out.println("Bean 定义加载的数量：" + loadBeanDefinitionsCount);

        lookupCollectionByType(beanFactory);
    }


    public static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合对象：" + users);
        }
    }
}
