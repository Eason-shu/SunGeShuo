package com.suns.controller;

import com.example.HelloProto;
import com.example.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GrpcClient("grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub stub;

    @RequestMapping("/test1")
    public String test1(String name) {
        System.out.println("name = " + name);
        HelloProto.HelloResponse helloResponse = stub.hello(HelloProto.HelloRequest.newBuilder().setName(name).build());
        return helloResponse.getResult();
    }
}
