package com.llicat.handler;

import com.llicat.dto.RpcRequest;
import com.llicat.net.RequestTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.handler.ProxyHandler
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 11:36
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class ProxyHandler implements InvocationHandler {


    private  String host;

    private  int port;

    public ProxyHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgs(args);
        rpcRequest.setMethod(method.getName());
        System.out.println(method.getDeclaringClass().getName());
        rpcRequest.setClassName(method.getDeclaringClass().getName());

        System.out.println(host+":"+port);
        Object transfer = RequestTransport.transfer(rpcRequest, host, port);

        return  transfer;
    }
}
