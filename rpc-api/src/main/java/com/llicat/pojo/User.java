package com.llicat.pojo;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.pojo.User
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:06
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class User implements Serializable {

    private static final long serialVersionUID = -8989163320193010219L;


    private int id;

    private  String name;


    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
