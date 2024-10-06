package com.example.SensorClient;

import com.example.SensorClient.Domain.Common.SensorMessage;
import com.example.SensorClient.Producers.SensorProducer;
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
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::sendData, 0, 50, TimeUnit.MILLISECONDS);
    }

    private void sendData() {
        List<SensorMessage> batch = sensors.stream()
                .map(SensorProducer::generateData)
                .collect(Collectors.toList());

        restTemplate.postForObject(serverUrl + "/api/measurements", batch, Void.class);
    }
}
