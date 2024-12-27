package com.uggthon.team01.service;


import lombok.RequiredArgsConstructor;
import org.example.hak.domain.entity.Image;
import org.example.hak.repository.ImageRepository;
import org.example.hak.util.S3Uploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {

    private final S3Uploader s3Uploader;
    private final ImageRepository imageRepository;

    public String uploadFile(MultipartFile file) throws IOException {
        String imageUrl = s3Uploader.upload(file);
        String imageId = UUID.randomUUID().toString();

        // DB 저장 로직
        Image image = new Image(imageId, imageUrl); // Image 객체 생성
        imageRepository.save(image); // DB에 저장

        return imageId;
    }
}