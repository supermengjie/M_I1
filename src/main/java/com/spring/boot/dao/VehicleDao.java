package com.spring.boot.dao;

import com.spring.boot.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleDao extends CrudRepository<VehicleEntity, Integer> {
}
