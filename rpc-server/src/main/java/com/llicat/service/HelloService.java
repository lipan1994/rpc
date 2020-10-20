package com.llicat.service;

import com.llicat.interfaces.IHelloService;
import com.llicat.pojo.User;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.service.HelloService
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class HelloService implements IHelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("say hello:"+name);
    }

    @Override
    public User saveUser(User user) {
        System.out.println("save success:"+user);
        return user;
    }
}
