package com.cebem.rickandmorty.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.rickandmorty.repositories.SensorRepository;
import com.cebem.rickandmorty.models.SensorModel;

@Service
public class SensorService {


    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    ///@Autowired
    //SensorRepository sensorRepositorie;

    public ArrayList<SensorModel> getAllSensors() {
        return (ArrayList<SensorModel>) sensorRepository.findAll();
    }

    public boolean existsId(long id) {
        return sensorRepository.existsById(id);
    }

    public SensorModel createSensor(SensorModel model) {
        return sensorRepository.save(model);
    }

    public boolean deleteSensor(long id) {
        try {
            sensorRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

}