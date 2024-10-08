package com.example.sensorclient;

import com.example.sensorclient.domain.common.SensorMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "sensorClient", url = "${server.url}")
public interface SensorFeignClient {

    // Endpoint for bulk messages
    @PostMapping("/api/measurements")
    void sendBulkMessages(@RequestBody List<SensorMessage> bulkMessages);

    // Endpoint for a single message
    @PostMapping("/api/measurement")
    void sendSingleMessage(@RequestBody SensorMessage message);
}