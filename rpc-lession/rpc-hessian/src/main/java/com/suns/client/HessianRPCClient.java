package com.suns.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.suns.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;

@Slf4j
public class HessianRPCClient {
    public static void main(String[] args) throws MalformedURLException {
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        //创建远端RPC服务的代理对象
        String URL = "http://localhost:8080/rpc_hessian_war/userServiceRPC";
        UserService userService = (UserService) hessianProxyFactory.create(UserService.class, URL);
        boolean userServiceRet = userService.login("xiaohei", "123456");
        log.debug("userServiceRet value is {} ", userServiceRet);

        /*
        userService.register(new User("sunshuai", "88888"));
        */


      /*  OrderService orderService = (OrderService) new HessianProxyFactory().create(OrderService.class, "http://localhost:8989/rpc-hessian/orderServiceRPC");
        orderService.showOrder();*/

    }
}
