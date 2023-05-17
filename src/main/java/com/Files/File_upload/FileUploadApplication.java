package com.Files.File_upload;

import com.Files.File_upload.services.FileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
public class FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}

	@Autowired
	private FileServices fileSer;

	@PostMapping("/filesSystem")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadProfile = fileSer.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadProfile);
	}
	@GetMapping("/filesSystem/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
		byte[] profileData = fileSer.downloadImageFromFilesSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("profile/png")).body(profileData);
	}
}
