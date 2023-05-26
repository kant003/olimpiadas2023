package com.cebem.rickandmorty.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name = "measurements")
public class MeasurementModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    float temperature;
    float humidity;
    float soilHumidity;

    private LocalDateTime createdAt;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //Date createdAt;
    
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    SensorModel sensor;

    public void setSensor(SensorModel sensor) {
        this.sensor = sensor;
    }
    public SensorModel getSensor() {
        return sensor;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public float getSoilHumidity() {
        return soilHumidity;
    }
    public void setSoilHumidity(float soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Método anotado con @PrePersist para establecer la fecha de creación antes de guardar en la base de datos

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public String toJson(){
        String r = "{";
        r+= "\"id\":"+id+",";
        r+= "\"temperature\":"+temperature+",";
        r+= "\"humidity\":"+humidity+",";
        r+= "\"soilHumidity\":"+soilHumidity+",";
        r+= "\"sensorId\":"+sensor.id+",";
        r+= "\"lat\":"+sensor.latitud+",";
        r+= "\"lng\":"+sensor.longitud+",";
        r+= "\"sensorMac\":\""+sensor.mac+"\",";
        r+= "\"createdAt\":\""+createdAt+"\"";
        r+= "}";
        return r;
    }

}