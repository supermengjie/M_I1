package com.spring.boot.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Vehicle {
    private int Id;
    private int Year;
    private String Make;
    private String Model;

    @JsonProperty("Id")
    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }

    @JsonProperty("Year")
    @Min(value = 1950, message ="Year must be greater than 1949")
    @Max(value = 2050, message = "Year must be less than 2051")
    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    @JsonProperty("Make")
    @NotNull
    @NotBlank(message="Make must not be empty")
    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    @JsonProperty("Model")
    @NotNull
    @NotBlank(message="Model must not be empty")
    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id=" + Id +
                ", Year=" + Year +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                '}';
    }
}
