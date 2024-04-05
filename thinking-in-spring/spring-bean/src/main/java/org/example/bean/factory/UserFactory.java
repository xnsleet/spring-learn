package org.example.bean.factory;

import org.example.ioc.overview.domain.User;

/**
 * {@link User} 工厂类
 *
 * @author sleet
 * @version 2024-03-05
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
