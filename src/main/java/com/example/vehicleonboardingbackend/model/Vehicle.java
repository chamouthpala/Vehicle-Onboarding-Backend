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

    public void setId(Long id) {

    }
}