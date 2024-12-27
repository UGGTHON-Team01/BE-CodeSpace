package com.uggthon.team01.controller;

import lombok.RequiredArgsConstructor;
import org.example.hak.domain.dto.GenerateRequestDto;
import org.example.hak.domain.dto.GenerateResponseDto;
import org.example.hak.service.AIService;
import org.example.hak.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileController {

    private final FileService fileService;
    private final AIService aiService;

    @PostMapping("/file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String imageId = fileService.uploadFile(file);
        return ResponseEntity.ok(imageId);
    }

    @PostMapping("/generate")
    public ResponseEntity<GenerateResponseDto> generateImages(@RequestBody GenerateRequestDto requestDto) {
        GenerateResponseDto responseDto = aiService.generateImages(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
