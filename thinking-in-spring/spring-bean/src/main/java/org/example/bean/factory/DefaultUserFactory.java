package org.example.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.*;

/**
 * 默认 {@link UserFactory} 实现
 *
 * @author sleet
 * @version 2024-03-05
 */
public class DefaultUserFactory
        implements UserFactory, InitializingBean {

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
}
