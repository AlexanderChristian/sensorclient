package com.example.sensorclient.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorMessage {
    private String sensorId;
    private Instant createdTime;
    private Object[] data;
    private String dataType;
    private String dataUnit;
}
