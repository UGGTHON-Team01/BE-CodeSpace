package com.uggthon.team01.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageUploadRequestDto {

  private MultipartFile file;
  private String scenario;
}
