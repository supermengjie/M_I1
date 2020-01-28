package com.spring.boot.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.vo.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VehicleController vehicleController;

    @Test
    public void getVehicles() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("x3");
        vehicle.setMake("Benz");
        vehicle.setYear(2009);
        List<Vehicle> allVehicles = Collections.singletonList(vehicle);
        given(vehicleController.getVehicles(null, null, null)).willReturn(allVehicles);

        mvc.perform(get("/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].Make", is(vehicle.getMake())))
                .andExpect(jsonPath("$[0].Year", is(vehicle.getYear())))
                .andExpect(jsonPath("$[0].Model", is(vehicle.getModel())));

    }

    @Test
    public void getVehiclesById() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("x3");
        vehicle.setMake("Benz");
        vehicle.setYear(2009);
        given(vehicleController.getVehicleById(vehicle.getId())).willReturn(vehicle);

        mvc.perform(get("/vehicles/" + vehicle.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("Make", is(vehicle.getMake())))
                .andExpect(jsonPath("Year", is(vehicle.getYear())))
                .andExpect(jsonPath("Model", is(vehicle.getModel())));
    }

    @Test
    public void addVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("x3");
        vehicle.setMake("Benz");
        vehicle.setYear(2009);
        given(vehicleController.addVehicles(any(Vehicle.class))).willReturn(vehicle);

        mvc.perform(post("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(vehicle))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("Make", is(vehicle.getMake())))
                .andExpect(jsonPath("Year", is(vehicle.getYear())))
                .andExpect(jsonPath("Model", is(vehicle.getModel())));

    }

    @Test
    public void updateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("x3");
        vehicle.setMake("Benz");
        vehicle.setYear(2009);
        doNothing().when(vehicleController).updateVehicle(any(Vehicle.class));
        mvc.perform(put("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(vehicle))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        verify(vehicleController, times(1)).updateVehicle(any(Vehicle.class));

    }

    @Test
    public void deleteVehicle() throws Exception {

        doNothing().when(vehicleController).deleteVehicle(1);
        mvc.perform(delete("/vehicles/1")).andExpect(status().isOk());
        verify(vehicleController, times(1)).deleteVehicle(1);
    }
}
