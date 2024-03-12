package org.example.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收示例
 *
 * @author sleet
 * @version 2024-03-12
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(BeanInitializationDemo.class);
        // 启动Spring 上下文
        applicationContext.refresh();
        // 关闭Spring 上下文
        applicationContext.close();
        // 强制GC
        System.gc();
    }
}
