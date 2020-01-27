package com.spring.boot.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

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
    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    @JsonProperty("Make")
    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    @JsonProperty("Model")
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
