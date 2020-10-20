package com.llicat.dto;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.dto.RpcRequest
 * @Description: 请求传输对象
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:26
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class RpcRequest implements Serializable {


    private static final long serialVersionUID = -7331191603231350662L;


    /*全限定类名*/
    private  String className;

    /*调用的方法名*/
    private String  method;

    /*参数列表*/
    private Object [] args;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
