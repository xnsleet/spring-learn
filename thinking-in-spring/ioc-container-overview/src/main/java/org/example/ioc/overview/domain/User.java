package org.example.ioc.overview.domain;

/**
 * 用户类
 *
 * @author sleet
 * @version 2024-01-25
 */
public class User {
    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User  createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("sleet");
        user.setAge(30);
        return user;
    }
}
