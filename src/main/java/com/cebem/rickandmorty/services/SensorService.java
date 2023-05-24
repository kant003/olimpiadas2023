package com.cebem.rickandmorty.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.rickandmorty.repositories.SensorRepository;
import com.cebem.rickandmorty.models.SensorModel;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepositorie;

    public ArrayList<SensorModel> getAllSensors() {
        return (ArrayList<SensorModel>) sensorRepositorie.findAll();
    }

    public boolean existsId(long id) {
        return sensorRepositorie.existsById(id);
    }

    public SensorModel createSensor(SensorModel model) {
        return sensorRepositorie.save(model);
    }

    public boolean deleteSensor(long id) {
        try {
            sensorRepositorie.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

}