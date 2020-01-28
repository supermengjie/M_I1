package com.spring.boot.service;

import com.spring.boot.vo.Vehicle;

import java.util.List;

public interface VehicleService {

    String update(Vehicle vechile);

    String save(Vehicle vehicle);

    List<Vehicle> findVehicles();

    List<Vehicle> findVehicles(Integer Year, String Model, String Make);

    Vehicle findVehiclesById(int id);

    void deleteVehicleById(int id);
}
