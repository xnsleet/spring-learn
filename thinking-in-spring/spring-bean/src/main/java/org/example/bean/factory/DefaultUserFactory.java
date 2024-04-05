package org.example.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.*;

/**
 * 默认 {@link UserFactory} 实现
 *
 * @author sleet
 * @version 2024-03-05
 */
public class DefaultUserFactory
        implements UserFactory, InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现 InitializingBean#afterPropertiesSet(): UserFactory 初始化中。。。");
    }

    // 基于 @PostConstruct 注解
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct : UserFactory 初始化中。。。");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory() : UserFactory 初始化中。。。");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy : UserFactory 销毁中。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy() : UserFactory 销毁中。。。");
    }

    public void doDestroy(){
        System.out.println("自定义销毁方法 doDestroy() : UserFactory 销毁中。。。");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("正在执行GC。。。");
    }

}
