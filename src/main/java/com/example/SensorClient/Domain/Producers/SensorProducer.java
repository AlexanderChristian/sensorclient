package com.example.SensorClient.Domain.Producers;

import com.example.SensorClient.Domain.Common.SensorMessage;

public interface SensorProducer {
    SensorMessage generateData();

    String getId();
}
