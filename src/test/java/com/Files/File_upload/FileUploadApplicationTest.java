package com.Files.File_upload;

import com.Files.File_upload.entity.FileData;
import com.Files.File_upload.services.FileServices;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest
class FileUploadApplicationTest {

//    @Mock
//    private FileServices fileServices;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void uploadImage() {
//        FileData fileData = new FileData("image", "text/plain", "C:/Users/PC/Folder/");
//
//        byte[] content = "test content".getBytes();
//        String fileName = "test.txt";
//        String originalFileName = "test_original.txt";
//        String contentType = "text/plain";
//
//        // create a mock multipart file object
//        MultipartFile mockMultipartFile = new MockMultipartFile(
//                fileName,
//                originalFileName,
//                contentType,
//                content
//        );
//
//        when(fileServices.uploadImageToFileSystem(file)).thenReturn(mockMultipartFile);
//    }
}