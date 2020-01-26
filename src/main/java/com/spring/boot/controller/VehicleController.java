package com.spring.boot.controller;

import com.spring.boot.service.VehicleService;
import com.spring.boot.vo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(name= "/vehicles", method = RequestMethod.GET, produces = "application/json")
    public List<Vehicle > getVehicles(){
        List<Vehicle> vehicles = vehicleService.findVehicles();
        System.out.println(vehicles);
        return  vehicles;
    }


    @RequestMapping(value= "/vehicles", method = RequestMethod.POST)
    public Vehicle addVehicles( @RequestBody Vehicle vehicle){
        System.out.println(vehicle);
        if(vehicle == null){
            System.out.println("no vehicle");
            return null;
        }else{
            System.out.println(vehicle);
            vehicleService.save(vehicle);
            return vehicle;
        }

    }

    @GetMapping("/")
    public String helloworld(){
        StringBuilder sb= new StringBuilder("hello world");
        return sb.toString();
    }
}
