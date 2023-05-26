package com.cebem.rickandmorty.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.rickandmorty.models.SensorModel;
import com.cebem.rickandmorty.services.SensorService;


@RestController
@CrossOrigin(origins = "*")
public class SensorController {
    
     @Autowired
    SensorService sensorService;


    @GetMapping("/")
    public String home(){
       return "Bienvenido a la API de sensores de aridez";
    } 
    //http://localhost:8080/sensors
    @GetMapping("/sensors")
    public String memes(){
        ArrayList<SensorModel> sensors = sensorService.getAllSensors();
        String json = "{";
        json+="\"sensors\":[";
        for(int i=0;i<sensors.size();i++){
            json+=sensors.get(i).toJson();
            if(i!=sensors.size()-1) json+=",";
        }
        json+="]";
        json+="}";
        return json;
    } 

    //http://localhost:8080/delete/sensor?id=1
    @DeleteMapping("/delete/sensor/{id}")
    public String memesDelete(@PathVariable String id){
        boolean result = sensorService.deleteSensor(Long.parseLong(id));
        if(result){
            return "OK borrado correcto";
        }else{
            return "ERROR al borrar el sensor";
        }
    }

    // http://localhost:8080/insert/sensor?mac=345&city=Vigo&latitud=42169618&longitud=-86833933
    @GetMapping("/insert/sensor")
    public String insertMeasurement(@RequestParam("mac") String mac, @RequestParam("city") String city,@RequestParam("latitud") String latitud,@RequestParam("longitud") String longitud){
        SensorModel model = new SensorModel();
        model.setMac(mac);
        model.setCity(city);
        model.setLatitud(latitud);
        model.setLongitud(longitud);
        sensorService.createSensor(model);
        return "Sensor creado con éxito";
    }
}