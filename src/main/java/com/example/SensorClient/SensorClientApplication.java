package com.example.SensorClient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorClientApplication {

    @Autowired
    SensorClientRunner sensorClientRunner;

    public static void main(String[] args) {
        SpringApplication.run(SensorClientApplication.class, args);
    }

    @PostConstruct
    public void startSensors() {
        sensorClientRunner.run();
    }

}
