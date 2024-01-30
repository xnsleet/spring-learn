package org.example.ioc.overview.dependency.domain;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * 用户信息仓储
 *
 * @author sleet
 * @version 2024-01-30
 */
public class UserRepository {

    private Collection<User> users;     //自定义 Bean

    private BeanFactory beanFactory;    //内建非 Bean 对象（依赖）

    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                ", beanFactory=" + beanFactory +
                ", userObjectFactory=" + userObjectFactory +
                '}';
    }
}
