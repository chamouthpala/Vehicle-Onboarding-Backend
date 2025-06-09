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


    @PostMapping("/uploadVehicleData")
    public ResponseEntity<?> uploadVehicleData(
            @RequestParam("images") MultipartFile file,
            @RequestParam("model") String model,
            @RequestParam("vehicleNumber") String regnum
    ) throws IOException {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }


        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }


        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
        file.transferTo(new File(filePath));


        String fileUrl = "http://localhost:8080/uploads/" + fileName;


        Vehicle vehicle = new Vehicle();
        vehicle.setModel(model);
        vehicle.setRegnum(regnum);
        vehicle.setImageUrls(List.of(fileUrl));


        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

        return ResponseEntity.ok(savedVehicle);
    }
}