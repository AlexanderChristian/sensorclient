package com.example.SensorClient;

import com.example.SensorClient.Domain.Common.SensorMessage;
import com.example.SensorClient.Domain.Producers.SensorProducer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class SensorClient {
    private final List<SensorProducer> sensors;
    @Autowired
    private SensorFeignClient feignClient;

    public SensorClient() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(SensorProducer sensor) {
        sensors.add(sensor);
    }

    public void start(String[] args) {
        System.out.println("Clients have started.");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        for (SensorProducer sensor : sensors) {
            executor.scheduleAtFixedRate(() -> sendData(sensor), 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    @CircuitBreaker(name = "sensorMessageSender", fallbackMethod = "fallbackMethod")
    public void sendData(SensorProducer sensor) {
        List<SensorMessage> messages = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            SensorMessage message = sensor.generateData();
            messages.add(message);
        }
        try {
            feignClient.sendBulkMessages(messages);
        }
        catch (Exception e){
            fallbackMethod(sensor, e);
        }
    }

    public void fallbackMethod(SensorProducer sensor, Exception exception) {
        System.out.println("Fallback triggered for sensor: " + sensor.getId() + ". Exception: " + exception.getMessage());
    }
}
