package com.llicat.interfaces;

import com.llicat.pojo.User;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.interfaces.IHelloService
 * @Description: 通用接口
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:05
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public interface IHelloService {

    /**
     * xxx
     * @param name
     */
    void sayHello(String name);


    /**
     * 保存
     * @param user
     * @return
     */
    User saveUser(User user);
}
