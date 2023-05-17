package com.Files.File_upload.services;

import com.Files.File_upload.repository.FileDataRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@SpringBootTest
class FileServicesTest {

    @Mock
    private FileDataRepository fileDataRepos;

    @InjectMocks
    private FileServices fileSer;



    @Test
    void uploadImageToFileSystem() throws IOException {
        byte[] content = "test content".getBytes();
        String fileName = "test.txt";
        String originalFileName = "test_original.txt";
        String contentType = "text/plain";

        // create a mock multipart file object
        MultipartFile mockMultipartFile = new MockMultipartFile(
                fileName,
                originalFileName,
                contentType,
                content
        );

        //File tempFile = File.createTempFile("abc", "bqr");
        String filePath = "C:/Users/PC/Folder/";

        // create the expected output string
        String expected = "file uploaded successfully " + filePath + "test_original.txt";

        // invoke the uploadImageToFileSystem() method with the mock multipart file
        String output = fileSer.uploadImageToFileSystem(mockMultipartFile);

        // assert that the output matches the expected string
        Assertions.assertEquals(expected, output);


    }

//@Test
//void uploadImageToFileSystem() throws IOException {

//    File tempFile = File.createTempFile("abc", "bqr");
//
//    String filePath = "C:/Users/PC/Folder/";
//    String expected = "file uploaded successfully " + filePath  + tempFile.getName();
//
//    // MultipartFile mockMultipartFile = new MockMultipartFile(tempFile.getName(), new FileInputStream(tempFile));
//    MultipartFile mockMultipartFile = new MockMultipartFile(tempFile.getName(),);
//
//    String output = fileSer.uploadImageToFileSystem(mockMultipartFile);
//        Assertions.assertEquals(expected, output);
//-------------------------------------------------------------------------------------------------------------
//    Path tempDir = Files.createTempDirectory("test-upload");
//    String filePath = tempDir.toString() + "/";
//    File tempFile = File.createTempFile("abc", "bqr", tempDir.toFile());
//
//    String expected = "file uploaded successfully " + filePath  + tempFile.getName();
//
//    MultipartFile mockMultipartFile = new MockMultipartFile(tempFile.getName(), new FileInputStream(tempFile));
//    String output = fileSer.uploadImageToFileSystem(mockMultipartFile);
//    Assertions.assertEquals(expected, output);
//
//    Files.deleteIfExists(tempFile.toPath());
//    Files.deleteIfExists(tempDir);
//}
}