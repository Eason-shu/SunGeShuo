package com.suns;

import com.google.gson.Gson;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GrpcClientRetry {
    public static void main(String[] args) throws InterruptedException {
        Map<String, ?> serviceConfig = getServiceConfig();
        System.out.println("GrpcClientRetry.main");

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .defaultServiceConfig(serviceConfig)
                .enableRetry()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(managedChannel);
        HelloProto.HelloRespnose helloRespnose = helloServiceBlockingStub.hello(HelloProto.HelloRequest.newBuilder().setName("sunshuai").build());

        System.out.println("helloRespnose.getResult() = " + helloRespnose.getResult());

        managedChannel.awaitTermination(5, TimeUnit.SECONDS);


    }


    @SneakyThrows
    private static Map<String, ?> getServiceConfig() {
        // 1 .读取文件
        File configFile = new File("/Users/sunshuai/Develop/code/java/idea/rpc-lession/rpc-grpc-adv-client/src/main/resources/service_config.json");
        Path path = configFile.toPath();
        byte[] bytes = Files.readAllBytes(path);
        // json --- object  jackson gson ...
        return new Gson().fromJson(new String(bytes), Map.class);
    }
}
