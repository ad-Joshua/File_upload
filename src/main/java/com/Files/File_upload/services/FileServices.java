package com.Files.File_upload.services;

import com.Files.File_upload.entity.FileData;
import com.Files.File_upload.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileServices {

    //@Autowired
    private FileDataRepository fileDataRepo;

    public FileServices(FileDataRepository fileDataRepo){
        this.fileDataRepo= fileDataRepo;
    }

    private static String FOLDER_PATH = "C:/Users/PC/Folder/";

//    public FileServices(FileDataRepository fileDataRepos) {
//        this.fileDataRepo = fileDataRepos;
//    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = getFileData(file);
        fileData = fileDataRepo.save(fileData);
        file.transferTo(new File(filePath));
        return "file uploaded successfully " + filePath;
    }

    private static FileData getFileData(MultipartFile file) {
        return FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(FOLDER_PATH + file.getOriginalFilename()).build();
    }

    public byte[] downloadImageFromFilesSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepo.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;


    }
}
