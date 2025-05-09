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

    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/uploads/";

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.println("Upload failed: file is empty.");
            return ResponseEntity.badRequest().body("File is empty");
        }
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            System.out.println("Created upload directory: " + uploadDir.getAbsolutePath() + " => " + created);
        } else {
            System.out.println("Upload directory already exists: " + uploadDir.getAbsolutePath());
        }
        String originalFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
        System.out.println("Saving file: " + originalFileName + " as " + fileName + " to " + filePath);

        file.transferTo(new File(filePath));

        return ResponseEntity.ok("http://localhost:8080/" + UPLOAD_DIR + fileName);
    }
}