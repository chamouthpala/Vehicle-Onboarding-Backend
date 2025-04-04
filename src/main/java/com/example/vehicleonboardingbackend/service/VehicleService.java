package com.example.vehicleonboardingbackend.service;

import com.example.vehicleonboardingbackend.model.Vehicle;
import com.example.vehicleonboardingbackend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}