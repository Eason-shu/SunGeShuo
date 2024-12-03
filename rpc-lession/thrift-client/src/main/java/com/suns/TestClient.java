package com.suns;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class TestClient {
    public static void main(String[] args) throws TException {
        TTransport tTransport = new TSocket("localhost", 9000);
        TProtocol tProtocol = new TBinaryProtocol(tTransport);

        UserService.Client userService = new UserService.Client(tProtocol);
        tTransport.open();

        User user = userService.queryUserByNameAndPassword("xiaopp", "123456");
        System.out.println(user);
    }
}
