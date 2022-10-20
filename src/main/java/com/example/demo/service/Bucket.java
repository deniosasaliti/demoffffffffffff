package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface Bucket {

    void upload(MultipartFile file, String bucketName, String fileName);

    byte[] download(String path, String key);


}
