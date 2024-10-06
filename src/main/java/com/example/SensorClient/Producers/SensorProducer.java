package com.example.SensorClient.Producers;

import com.example.SensorClient.Domain.Common.SensorMessage;

public interface SensorProducer {
    SensorMessage generateData();

    String getId();
}
