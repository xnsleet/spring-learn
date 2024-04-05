package org.example.ioc.overview.dependency.container;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为IoC容器示例
 *
 * @author sleet
 * @version 2024-01-31
 */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 Bean 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // XML文件地址 classpath 路径
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        // 读取配置
        int loadBeanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + loadBeanDefinitionCount);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合对象：" + users);
        }
    }

}
