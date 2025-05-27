//package com.example.vehicleonboardingbackend.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/upload")
//@CrossOrigin(origins = "*")
//public class FileUploadController {
//
//    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/uploads/";
//
//    @PostMapping
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("File is empty");
//        }
//
//        File uploadDir = new File(UPLOAD_DIR);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs();
//        }
//
//        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
//        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
//        file.transferTo(new File(filePath));
//
//        // Return a URL that can be accessed from the frontend
//        String fileUrl = "http://localhost:8080/uploads/" + fileName;
//        return ResponseEntity.ok(fileUrl);
//    }
//}
