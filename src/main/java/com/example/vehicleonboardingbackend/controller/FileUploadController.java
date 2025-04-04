package com.example.vehicleonboardingbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();

        file.transferTo(new File(filePath));

        return ResponseEntity.ok("http://localhost:8080/" + UPLOAD_DIR + fileName);
    }
}