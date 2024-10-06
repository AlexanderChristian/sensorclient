package com.example.SensorClient.Domain.Common;

import java.time.Instant;
import java.util.Objects;

public class SensorMessage {
    private String sensorId;
    private Instant createdTime;
    private Object[] data;
    private String dataType;
    private String dataUnit;

    public SensorMessage(String sensorId, Instant createdTime, Object[] data, String dataType, String dataUnit) {
        this.sensorId = sensorId;
        this.createdTime = createdTime;
        this.data = data;
        this.dataType = dataType;
        this.dataUnit = dataUnit;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorMessage that = (SensorMessage) o;
        return Objects.equals(sensorId, that.sensorId) && Objects.equals(createdTime, that.createdTime) && Objects.equals(data, that.data) && Objects.equals(dataType, that.dataType) && Objects.equals(dataUnit, that.dataUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, createdTime, data, dataType, dataUnit);
    }

    @Override
    public String toString() {
        return "SensorMessage{" +
                "sensorId='" + sensorId + '\'' +
                ", createdTime=" + createdTime +
                ", data=" + data +
                ", dataType='" + dataType + '\'' +
                ", dataUnit='" + dataUnit + '\'' +
                '}';
    }
}
