package com.example.sensorclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SensorClientApplication {

    @Autowired
    SensorClientRunner sensorClientRunner;

    public static void main(String[] args) {
        SpringApplication.run(SensorClientApplication.class, args);
    }

}
