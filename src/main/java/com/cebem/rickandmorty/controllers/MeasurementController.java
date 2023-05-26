package com.cebem.rickandmorty.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.rickandmorty.services.MeasurementService;
import com.cebem.rickandmorty.services.SensorService;
import com.cebem.rickandmorty.models.MeasurementModel;
import com.cebem.rickandmorty.models.SensorModel;
import com.cebem.rickandmorty.repositories.SensorRepository;

@RestController
public class MeasurementController {
     @Autowired
    MeasurementService measurementService;
    @Autowired
    SensorService sensorService;
    @Autowired
    SensorRepository sensorRepository;

    // http://localhost:8080/getMeasuresOfSensor/1
    @GetMapping("/getMeasuresOfSensor/{id}")
    public String memesDelete(@PathVariable String id) {
              ArrayList<MeasurementModel> measures = measurementService.getAllMeasurementsOfSensor(Long.parseLong(id));
        
        String json = "{";
        json+="\"measures\":[";
        for(int i=0;i<measures.size();i++){
            json+=measures.get(i).toJson();
            if(i!=measures.size()-1) json+=",";
        }
        json+="]";
        json+="}";
        return json;
    }


   /*  List<MeasurementModel> findLatestMedidasByAllSensors() {
        
        List<SensorModel> sensors = findAllSensors();
        List<MeasurementModel> latestMedidas = new ArrayList<>();
        for (SensorModel sensor : sensors) {
            List<MeasurementModel> medidas = findBySensorIdOrderByCreatedAtDesc(sensor);
            if (!medidas.isEmpty()) {
                latestMedidas.add(medidas.get(0));
            }
        }
        return latestMedidas;
    }*/



     @GetMapping("/measures")
    public String lasterMeasuresAllSensors() {

        List<SensorModel> sensors = sensorService.getAllSensors();

        List<MeasurementModel> latestMedidas = new ArrayList<>();
        for (SensorModel sensor : sensors) {
            List<MeasurementModel> medidas = measurementService.findMeasuresBySensorIdOrderByCreatedAtDesc(sensor.getId());
            if (!medidas.isEmpty()) {
                latestMedidas.add(medidas.get(0));
            }
        }
        
        
        String json = "{";
        json+="\"measures\":[";
        for(int i=0;i<latestMedidas.size();i++){
            json+=latestMedidas.get(i).toJson();
            if(i!=latestMedidas.size()-1) json+=",";
        }
        json+="]";
        json+="}";
        return json;
    }

    // http://localhost:8080/insert/measurement?temperature=4&humidity=5&soilHumidity=6&sensorId=1
    @GetMapping("/insert/measurement")
    public String insertMeasurement(@RequestParam("temperature") float temperature,
            @RequestParam("humidity") float humidity, @RequestParam("soilHumidity") float soilHumidity,
            @RequestParam("sensorId") long sensorId) {

        Optional<SensorModel> sensorOptional = sensorRepository.findById(sensorId);
        if (sensorOptional.isPresent()) {
            SensorModel sensor = sensorOptional.get();

            try {
                MeasurementModel medida = new MeasurementModel();
                medida.setTemperature(temperature);
                medida.setHumidity(humidity);
                medida.setSoilHumidity(soilHumidity);

                medida.setSensor(sensor);

                measurementService.createMeasurement(medida);
            } catch (Exception ex) {
                return "no se puede crear la medida";
            }
        } else {
            return "Error en la creacion de la medida el sensor no existe";
        }

        return "Measurement creado con éxito";
    }
}