package com.suns;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GprcClient2 {
    public static void main(String[] args) {
        //1 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        //2 获得代理对象 stub
        try {
            HelloServiceGrpc.HelloServiceBlockingStub helloService = HelloServiceGrpc.newBlockingStub(managedChannel);
            //3. 完成RPC调用
            //3.1 准备参数
            HelloProto.HelloRequest1.Builder builder = HelloProto.HelloRequest1.newBuilder();
            builder.addName("sunshuai1");
            builder.addName("sunshuai2");
            builder.addName("sunshuai3");
            HelloProto.HelloRequest1 helloRequest1 = builder.build();

            HelloProto.HelloResponse1 helloResponse1 = helloService.hello1(helloRequest1);
            String result = helloResponse1.getResult();
            System.out.println("result = " + result);


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            managedChannel.shutdown();
        }
    }
}
