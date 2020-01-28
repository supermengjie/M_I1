package com.spring.boot.controller;

import com.spring.boot.service.VehicleService;
import com.spring.boot.vo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

   @GetMapping()
    public List<Vehicle > getVehicles(@RequestParam(value = "Year", required = false) Integer Year, @RequestParam(value = "Make", required = false) String Make, @RequestParam(value = "Model",required = false)String Model){
       System.out.println(Year+" "+Make+" "+Model);
       List<Vehicle> vehicles = vehicleService.findVehicles();
        System.out.println(vehicles);
        return  vehicles;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Vehicle addVehicles( @RequestBody Vehicle vehicle){
        System.out.println(vehicle);
        if(vehicle == null){
            System.out.println("no vehicle");
            return null;
        }else{
           // System.out.println(vehicle);
            vehicleService.save(vehicle);
            return vehicle;
        }

    }

    @PutMapping()
    public void updateVehicle(@RequestBody Vehicle vehicle){
        System.out.println(vehicle);
        vehicleService.update(vehicle);

    }


    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id){
        System.out.println(id);

        Vehicle vehicle = vehicleService.findVehiclesById(id);
        return vehicle;
    }




    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id){
        System.out.println("delete " +id);
        vehicleService.deleteVehicleById(id);

    }



}
