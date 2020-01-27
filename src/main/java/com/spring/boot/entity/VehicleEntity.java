package com.spring.boot.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_tbl")
public class VehicleEntity {
    private int Id;
    private int Year;
    private String Make;
    private String Model;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "Id=" + Id +
                ", Year=" + Year +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                '}';
    }
}
