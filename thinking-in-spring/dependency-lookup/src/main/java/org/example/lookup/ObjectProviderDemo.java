package org.example.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 *
 * @author sleet
 * @version 2024-04-06
 */
public class ObjectProviderDemo {   //@Configuration是非必填的
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将 ObjectProviderDemo 作为配置类
        applicationContext.register(ObjectProviderDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找
        lookupByObjectProvider(applicationContext);
        //关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String HelloWord() { // 方法名称就是 Bean 名称
        return "hello world!!!";
    }

    /**
     * 单一类型查找
     */
    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        String object = beanProvider.getObject();
        System.out.println(object);
    }
}
