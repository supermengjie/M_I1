package com.spring.boot.dao;

import com.spring.boot.entity.VehicleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VehicleDao extends CrudRepository<VehicleEntity, Integer> {
    @Query("select v from VehicleEntity as v where v.year = ?1 and v.model=?2 and v.make=?3")
    Iterable<VehicleEntity> findByYearModelMake(Integer year, String model, String make);

    @Query("select v from VehicleEntity as v where v.year = ?1 and v.model=?2")
    Iterable<VehicleEntity> findByYearModel(Integer year, String model);

    @Query("select v from VehicleEntity as v where v.year = ?1 and v.make=?2")
    Iterable<VehicleEntity> findByYearMake(Integer year, String make);

    @Query("select v from VehicleEntity as v where v.model=?1 and v.make=?2")
    Iterable<VehicleEntity> findByModelMake(String model, String make);

    @Query("select v from VehicleEntity as v where v.year=?1")
    Iterable<VehicleEntity> findByYear(Integer year);

    @Query("select v from VehicleEntity as v where v.model=?1")
    Iterable<VehicleEntity> findByModel(String model);

    @Query("select v from VehicleEntity as v where v.make=?1")
    Iterable<VehicleEntity> findByMake(String make);
}
