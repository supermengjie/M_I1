package com.spring.boot.service;

import com.spring.boot.vo.Vehicle;

import java.util.List;

public interface VehicleService {

    String update(Vehicle vechile);

    String save(Vehicle vehicle);

    List<Vehicle> findVehicles();

    Vehicle findVehiclesById(int id);

    void deleteVehicleById(int id);
}
