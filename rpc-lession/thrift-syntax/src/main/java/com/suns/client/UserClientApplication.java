package com.suns.client;

import com.suns.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description
 * @Author EasonShu
 * @Data 2024/12/3 下午10:08
 */
public class UserClientApplication {
    public static void main(String[] args) {
        TTransport transport =null;
        try {
            // 连接
            transport = new TFramedTransport(new TSocket("127.0.0.1",8803),600);
            // 协议,注意服务端保持一致
            TProtocol protocol = new TCompactProtocol(transport);
            // 调用方法
            UserService.Client client = new UserService.Client(protocol);
            // 打开连接
            transport.open();
            // 调用方法
            String result = client.sayHello("EasonShu");
            // 输出结果
            System.out.println("Result =: " + result);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
}
