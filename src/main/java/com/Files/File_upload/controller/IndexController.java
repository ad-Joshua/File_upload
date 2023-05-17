package com.Files.File_upload.controller;

import com.Files.File_upload.entity.FileData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){

        return "index";
    }



}
