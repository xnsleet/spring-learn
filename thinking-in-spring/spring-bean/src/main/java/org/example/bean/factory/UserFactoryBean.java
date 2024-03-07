package org.example.bean.factory;

import org.example.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link User} Bean 的{@link FactoryBean} 的实现
 *
 * @author sleet
 * @version 2024-03-05
 */
public class UserFactoryBean
implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
