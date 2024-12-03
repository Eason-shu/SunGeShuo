package com.suns.server;

import com.suns.UserService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFastFramedTransport;

/**
 * @Description
 * @Author EasonShu
 * @Data 2024/12/3 下午10:05
 */
public class UserServerApplication {
    public static void main(String[] args) throws TTransportException {
        // 建立连接
        TNonblockingServerSocket serverSocket =new TNonblockingServerSocket(8803);
        // 建立高可用server
        THsHaServer.Args arg=new THsHaServer.Args(serverSocket).maxWorkerThreads(4).minWorkerThreads(2);
        // 处理器
        UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
        // 设置协议处理器
        arg.protocolFactory(new TCompactProtocol.Factory());
        // 设置传输处理器
        arg.transportFactory(new TFastFramedTransport.Factory());
        // 处理器工厂
        arg.processorFactory(new TProcessorFactory(processor));
        // 开始执行
        TServer tServer = new THsHaServer(arg);
        // 启动服务
        System.out.println("Running Simple Server");
        // 服务启动
        tServer.serve();
    }
}
