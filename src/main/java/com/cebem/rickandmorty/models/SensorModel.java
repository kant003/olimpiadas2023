package com.cebem.rickandmorty.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "sensor")
public class SensorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    long id;
    String mac;
    String latitud;
    String longitud;
    public String getLatitud() {
        return latitud;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    String city;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }

    public String toJson(){
        String r = "{";
        r+= "\"id\":"+id+",";
        r+= "\"mac\":\""+mac+"\",";
        r+= "\"lat\":"+latitud+",";
        r+= "\"lng\":"+longitud+",";
        r+= "\"city\":\""+city+"\"";
        r+= "}";
        return r;
    }

}