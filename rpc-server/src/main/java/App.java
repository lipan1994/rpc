import com.llicat.interfaces.IHelloService;
import com.llicat.proxy.RpcProxy;
import com.llicat.service.HelloService;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: PACKAGE_NAME.App
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 11:52
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class App {

    public static void main(String[] args) {

        RpcProxy rpcProxy=new RpcProxy();
        //实例化服务
        IHelloService helloService=new HelloService();
        //将服务发布到9001端口
        rpcProxy.publisher(9001,helloService);

    }
}
