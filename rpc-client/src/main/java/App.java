import com.llicat.interfaces.IHelloService;
import com.llicat.pojo.User;
import com.llicat.proxy.RpcClientProxy;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: PACKAGE_NAME.App
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: lipan
 * @date: 2020/10/20 11:29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/10/20      lipan          v1.0.0               修改原因
 */

public class App {

    public static void main(String[] args) {

         //获取远程服务实例
        RpcClientProxy rp =new RpcClientProxy();
        IHelloService service= rp.getInstance(IHelloService.class,"localhost",9001);

        service.sayHello("飞飞");

        User user = service.saveUser(new User(1, "飞飞"));

        System.out.println("result:"+user);

    }
}
