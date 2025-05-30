package com.example.vehicleonboardingbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private int year;
    private String regnum;
    private String vehicletype;
    private String fuelType;

    @ElementCollection
    private List<String> imageUrls;  // Store image URLs

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public String getRegnum() {
        return regnum;
    }
    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }
    public String getVehicletype() {
        return regnum;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setImageUrls(List imageUrls) {
        this.imageUrls = imageUrls;
    }
    public List getImageUrls() {
        return imageUrls;
    }


}