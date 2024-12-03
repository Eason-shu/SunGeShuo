package com.suns;

import com.suns.service.UserServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class TestServer {
    public static void main(String[] args) throws TTransportException {
        //1.TTransport
        TServerTransport tServerTransport = new TServerSocket(9000);
        //2. TBinaryProtocol
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
        //3. TProcessor 把对应的功能书写发布了
        UserService.Processor processor = new UserService.Processor(new UserServiceImpl());

        TSimpleServer.Args arg = new TSimpleServer.Args(tServerTransport);
        arg.processor(processor);
        arg.protocolFactory(factory);


        //TServer发布服务
        TServer tServer = new TSimpleServer(arg);
        tServer.serve();
    }
}
