package Dao;

import Entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleDao extends CrudRepository<VehicleEntity, Integer> {
}
