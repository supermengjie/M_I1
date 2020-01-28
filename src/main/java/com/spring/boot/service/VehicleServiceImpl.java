package com.spring.boot.service;

import com.spring.boot.dao.VehicleDao;
import com.spring.boot.entity.VehicleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boot.vo.Vehicle;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public String update(Vehicle vehicle){
        Optional<VehicleEntity> optVehicleEntity=  vehicleDao.findById(vehicle.getId());
        if(optVehicleEntity.isPresent()){
            VehicleEntity vehicleEntity = optVehicleEntity.get();
            vehicleEntity.setMake(vehicle.getMake());
            vehicleEntity.setModel(vehicle.getModel());
            vehicleEntity.setYear(vehicle.getYear());
            vehicleDao.save(vehicleEntity);
            return "success";
        }else{
            return "failure";
        }

    }

    @Override
    public String save(Vehicle vehicle){
        VehicleEntity  vehicleEntity = new VehicleEntity();
        BeanUtils.copyProperties(vehicle, vehicleEntity);
        vehicleDao.save(vehicleEntity);
        return "success";
    }

    @Override
    public List<Vehicle> findVehicles(){

       Iterable<VehicleEntity> ves= vehicleDao.findAll();
       List<Vehicle> vs= new ArrayList<>();
       for(VehicleEntity ve : ves){
           Vehicle v = new Vehicle();
           BeanUtils.copyProperties(ve, v);
           vs.add(v);
       }
        return vs;
    }

    @Override
    public List<Vehicle> findVehicles(Integer Year, String Model, String Make){
        Iterable<VehicleEntity> ves;
        System.out.println(Year+" "+Model+" "+Make);
        if(Year!=null && Model!=null && Make!=null){
            ves= vehicleDao.findByYearModelMake(Year,Model,Make);
        }else if(Year!=null&&Model!=null){
            ves=vehicleDao.findByYearModel(Year,Model);
        }else if(Year!=null&&Make!=null){
            ves=vehicleDao.findByYearMake(Year,Make);
        }else if(Model!=null && Make!=null){
            ves=vehicleDao.findByModelMake(Model, Make);
        }else if(Year!=null){
            ves =vehicleDao.findByYear(Year);
        }else if(Model!=null){
            ves= vehicleDao.findByModel(Model);
        }else if(Make!=null){
            System.out.println("hi");
            ves=vehicleDao.findByMake(Make);
            System.out.println(ves);
        }else{
            ves=vehicleDao.findAll();
        }
        //Iterable<VehicleEntity> ves= vehicleDao.findAll();
        List<Vehicle> vs= new ArrayList<>();
        for(VehicleEntity ve : ves){
            Vehicle v = new Vehicle();
            BeanUtils.copyProperties(ve, v);
            vs.add(v);
        }
        return vs;
    }

    public List<Vehicle> findVehiclesFiltered(int year, String make, String model){

        return null;
    }

    @Override
    public Vehicle findVehiclesById(int id){
        Optional<VehicleEntity> vehicleEntity = vehicleDao.findById(id);
        if(vehicleEntity.isPresent()) {
            Vehicle vehicle = new Vehicle();
            BeanUtils.copyProperties(vehicleEntity.get(), vehicle);
            return vehicle;
        }else {
            return null;
        }
    }

    @Override
    public void deleteVehicleById(int id){
        if(vehicleDao.findById(id).isPresent()){
            vehicleDao.deleteById(id);
            System.out.println("deleted");
        }else{
            System.out.println("id not present");
        }


    }
}
