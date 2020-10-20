package com.llicat.proxy;

import com.llicat.handler.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.RpcClientProxy
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 11:27
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class RpcClientProxy {


  public     <T>  T getInstance(Class<T> inter,String host,int port){

          return (T)Proxy.newProxyInstance(inter.getClassLoader(), new Class<?>[]{inter},new ProxyHandler(host,port));
       }

}
