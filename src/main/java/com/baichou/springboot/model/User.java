package com.baichou.springboot.model;
/**
 * 用户
 *
 * @author zyang0419
 * @create 2016-11-02 下午5:25
 **/
public class User {
    private Long   id;
    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
