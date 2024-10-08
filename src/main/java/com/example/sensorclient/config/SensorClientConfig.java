package com.example.sensorclient.config;

import com.example.sensorclient.domain.producers.AccelerometerSensor;
import com.example.sensorclient.SensorClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.sensorclient.domain.Constants.ACCELEROMETER;

@Configuration
public class SensorClientConfig {

    @Value("${server.url}")
    private String serverUrl;

    @Bean
    public SensorClient sensorClient() {
        SensorClient sensorClient = new SensorClient();

        sensorClient.addSensor(new AccelerometerSensor("ACC001", ACCELEROMETER, "g-force"));
        sensorClient.addSensor(new AccelerometerSensor("ACC002", ACCELEROMETER, "m/s^2"));

        return sensorClient;
    }
}
