package com.cebem.rickandmorty.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cebem.rickandmorty.models.SensorModel;

@Repository
public interface SensorRepository extends CrudRepository<SensorModel, Long>{
    
}