package com.suns;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        Consul consulConnection = Consul.builder().build();
        HealthClient healthClient = consulConnection.healthClient();
        ConsulResponse<List<ServiceHealth>> allServiceInstances = healthClient.getHealthyServiceInstances("grpc-server");

        List<ServiceHealth> response = allServiceInstances.getResponse();
        for (ServiceHealth serviceHealth : response) {
            System.out.println("serviceHealth.getService() = " + serviceHealth.getService());
        }
    }
}
