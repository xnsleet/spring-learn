package org.example.ioc.overview.dependency.domain;

import org.example.ioc.overview.dependency.annotation.Supper;

/**
 * 超级用户
 *
 * @author sleet
 * @version 2024-01-29
 */
@Supper
public class SupperUser
        extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String  toString() {
        return "SupperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
