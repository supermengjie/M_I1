package com.spring.boot.controller;

import com.spring.boot.service.VehicleService;
import com.spring.boot.vo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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


    @PostMapping(value= "/vehicles")
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

    @RequestMapping(name = "/vehicles", method = RequestMethod.PUT)
    public String updateVehicle(@RequestBody Vehicle vehicle){

        return vehicleService.update(vehicle);
    }


    @GetMapping("/vehicles/{id}")
    public Vehicle findVehicleById(@PathVariable Integer id){
        System.out.println(id);

        Vehicle vehicle = vehicleService.findVehiclesById(id);
        return vehicle;
    }



    @DeleteMapping("vehicles/{id}")
    public void deleteVehicle(@PathVariable Integer id){
        System.out.println("delete " +id);
        vehicleService.deleteVehicleById(id);

    }


    @GetMapping("/")
    public String helloworld(){
        StringBuilder sb= new StringBuilder("hello world");
        return sb.toString();
    }
}
