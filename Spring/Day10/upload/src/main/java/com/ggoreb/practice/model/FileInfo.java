package com.ggoreb.practice.model;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class FileInfo {
    private MultipartFile file;
}
