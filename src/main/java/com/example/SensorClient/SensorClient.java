package com.example.SensorClient;

import com.example.SensorClient.Domain.Common.SensorMessage;
import com.example.SensorClient.Domain.Producers.SensorProducer;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SensorClient {
    private final List<SensorProducer> sensors;
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public SensorClient(String serverUrl) {
        this.sensors = new ArrayList<>();
        this.restTemplate = new RestTemplate();
        this.serverUrl = serverUrl;
    }

    public void addSensor(SensorProducer sensor) {
        sensors.add(sensor);
    }

    public void start() {
        System.out.println("Clients have started.");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(sensors.size());

        for (SensorProducer sensor : sensors) {
            executor.scheduleAtFixedRate(() -> sendData(sensor), 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void sendData(SensorProducer sensor) {
        List<SensorMessage> messages = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++) {
            SensorMessage message = sensor.generateData();
            messages.add(message);
        }
        System.out.println("Sending data for sensor: " + sensor.getId());

        try {
            restTemplate.postForObject(serverUrl + "/api/measurements", messages, Void.class);
        }
        catch(Exception e){
            System.exit(0);
        }
    }
}
