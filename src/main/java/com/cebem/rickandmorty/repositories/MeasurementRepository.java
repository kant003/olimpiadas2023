package com.cebem.rickandmorty.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cebem.rickandmorty.models.MeasurementModel;
import com.cebem.rickandmorty.models.SensorModel;

@Repository
public interface MeasurementRepository extends CrudRepository<MeasurementModel, Long> {
    List<MeasurementModel> findBySensorId(Long sensorId);

    List<MeasurementModel> findBySensorIdOrderByCreatedAtDesc(Long sensorId);
    /*@Query("SELECT m FROM measurements m WHERE m.sensor = :sensor ORDER BY m.createdAt DESC")
    ArrayList<MeasurementModel> findLatestMedidaBySensor(@Param("sensor") SensorModel sensor);
    
*/
   /*  @Query("SELECT s FROM sensor s")
    public List<SensorModel> findAllSensors();*/
   /* default List<MeasurementModel> findLatestMedidasByAllSensors() {
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
}