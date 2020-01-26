package com.spring.boot.service;

import org.springframework.stereotype.Service;
import com.spring.boot.vo.Vehicle;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Override
    public String update(Vehicle vechile){

        return "";
    }

    @Override
    public String save(Vehicle vehicle){

        return "";
    }

    @Override
    public List<Vehicle> findVehicles(){


        return null;
    }

    @Override
    public Vehicle findVehiclesById(int id){

        return null;
    }

    @Override
    public void deleteStudentById(int id){

    }
}
