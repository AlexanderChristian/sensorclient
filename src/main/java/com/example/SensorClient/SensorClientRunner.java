package com.example.SensorClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SensorClientRunner implements CommandLineRunner {

    @Autowired
    private SensorClient sensorClient;

    @Override
    public void run(String... args) {
        sensorClient.start(args);
    }
}
