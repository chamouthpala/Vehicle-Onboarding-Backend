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
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        existingVehicle.setMake(vehicle.getMake());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setRegnum(vehicle.getRegnum());
        existingVehicle.setVehicletype(vehicle.getVehicletype());
        existingVehicle.setFuelType(vehicle.getFuelType());
        existingVehicle.setImageUrls(vehicle.getImageUrls());

        return vehicleRepository.save(existingVehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}