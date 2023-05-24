package com.cebem.rickandmorty.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cebem.rickandmorty.models.MeasurementModel;
@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementModel, Long> {
    List<MeasurementModel> findBySensorId(Long sensorId);
}