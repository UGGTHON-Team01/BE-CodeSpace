package com.uggthon.team01.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.uggthon.team01.dto.GenerateRequestDto;
import com.uggthon.team01.dto.GenerateResponseDto;
import com.uggthon.team01.service.AIService;
import com.uggthon.team01.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileController {

  private final FileService fileService;
  private final AIService aiService;

  @PostMapping("/file")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
      throws IOException {
    String imageId = fileService.uploadFile(file);
    return ResponseEntity.ok(imageId);
  }

  @PostMapping("/generate")
  public ResponseEntity<GenerateResponseDto> generateImages(
      @RequestBody GenerateRequestDto requestDto) {
    GenerateResponseDto responseDto = aiService.generateImages(requestDto);
    return ResponseEntity.ok(responseDto);
  }
}
