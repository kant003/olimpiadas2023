package com.cebem.rickandmorty.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.rickandmorty.repositories.MeasurementRepository;
import com.cebem.rickandmorty.models.MeasurementModel;
@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public MeasurementModel createMeasurement(MeasurementModel model){
        return measurementRepository.save(model);
    }


    public ArrayList<MeasurementModel> getAllMeasurements() {
        return (ArrayList<MeasurementModel>) measurementRepository.findAll();
    }

    public ArrayList<MeasurementModel> getAllMeasurementsOfSensor(Long sensorId) {
        return (ArrayList<MeasurementModel>) measurementRepository.findBySensorId(sensorId);
    }

    public boolean existsId(long id) {
        return measurementRepository.existsById(id);
    }

    public MeasurementModel createMeasurements(MeasurementModel model) {
        return measurementRepository.save(model);
    }

    public boolean deleteMeasurements(long id) {
        try {
            measurementRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List<MeasurementModel> findMeasuresBySensorIdOrderByCreatedAtDesc(Long idSensor){
        return measurementRepository.findBySensorIdOrderByCreatedAtDesc(idSensor);
    }


   

   /*  public ArrayList<MeasurementModel>  findLatestMedidasByAllSensors(){
        return (ArrayList<MeasurementModel>) measurementRepository.findLatestMedidasByAllSensors();
    }*/
}