package com.llicat.proxy;

import com.llicat.handler.ProcessorHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.proxy.RpcProxy
 * @Description: 服务发布
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 10:40
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class RpcProxy{


    //使用线程池是为了增加 bio的并发连接能力
    ExecutorService service=Executors.newCachedThreadPool();

    //发布服务
    public void publisher(int port,Object target){

        ServerSocket serverSocket=null;

        try {
            serverSocket=new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                service.execute(new ProcessorHandler(target,socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //出了异常需要关闭网络
            if(null!=serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
