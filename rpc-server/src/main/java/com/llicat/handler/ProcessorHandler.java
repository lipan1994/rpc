package com.llicat.handler;

import com.llicat.dto.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.handler.ProcessorHandler
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:51
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class ProcessorHandler implements Runnable{

    //方法调用的实例
    private  Object service;
    //端口
    private Socket socket;


    public ProcessorHandler() {
    }

    public ProcessorHandler(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    public Object getService() {
        return service;
    }

    public void setService(Object service) {
        this.service = service;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream=null;
        ObjectOutputStream oos=null;

        try {
            //从网络流中读一个请求对象
            objectInputStream=new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest= (RpcRequest) objectInputStream.readObject();
            Object ret=doHandler(rpcRequest,service);

            //将请求结果写回去
            oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(ret);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
             //先开后关
             if(null!=oos){
                 try {
                     oos.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }

             if(null!=objectInputStream){
                 try {
                     objectInputStream.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }

    }

    /**
     * 方法的调用
     * @param rpcRequest
     * @param service
     * @return
     */
    private Object doHandler(RpcRequest rpcRequest, Object service) {
        try {
            Object[] args = rpcRequest.getArgs();
            String methodName = rpcRequest.getMethod();
            String className = rpcRequest.getClassName();

            Class<?> aClass = Class.forName(className);
            Class<?> [] types=new Class[args.length];
            for (int i = 0; i < types.length; i++) {
                types[i]=args[i].getClass();
            }
            Method method = aClass.getMethod(methodName, types);
            return method.invoke(service,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
