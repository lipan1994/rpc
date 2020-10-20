package com.llicat.net;

import com.llicat.dto.RpcRequest;
import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: com.llicat.net.RequestTransport
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 11:37
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class RequestTransport {


    public static Object transfer(RpcRequest rpcRequest, String host, int port) {
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            //写请求
            oos.writeObject(rpcRequest);
            oos.flush();
            //读响应(需要注意的是需要写写数据到服务端，然后服务端不会阻塞，写数据到客户端，获取输入流才能成功)
            ois = new ObjectInputStream(socket.getInputStream());
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
