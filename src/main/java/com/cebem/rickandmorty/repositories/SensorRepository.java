package com.cebem.rickandmorty.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cebem.rickandmorty.models.SensorModel;

@Repository
public interface SensorRepository extends JpaRepository<SensorModel, Long> {

    //@Query("SELECT s FROM Sensor s")
    //List<SensorModel> findAllSensors();
    //List<SensorModel> findAll();

   // List<SensorModel> findByCity(String city);
}