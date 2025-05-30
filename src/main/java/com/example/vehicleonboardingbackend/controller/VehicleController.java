package com.example.vehicleonboardingbackend.controller;

import com.example.vehicleonboardingbackend.model.Vehicle;
import com.example.vehicleonboardingbackend.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";




    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
        System.out.println("Uploading to path: " + filePath);
        file.transferTo(new File(filePath));

        String fileUrl = "http://172.104.60.219:8080/uploads/" + fileName;
        return ResponseEntity.ok(fileUrl);
    }
}