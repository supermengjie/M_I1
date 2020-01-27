package com.spring.boot.dao;

import com.spring.boot.entity.VehicleEntity;
import com.spring.boot.vo.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleDao extends CrudRepository<VehicleEntity, Integer> {

}
