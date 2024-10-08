package com.example.sensorclient.domain.producers;

import com.example.sensorclient.domain.common.SensorMessage;

public interface SensorProducer {
    SensorMessage generateData();

    String getId();
}
