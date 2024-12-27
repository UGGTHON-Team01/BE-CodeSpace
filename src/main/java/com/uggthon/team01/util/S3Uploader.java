package com.uggthon.team01.util;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class S3Uploader {

  private final AmazonS3 amazonS3;

  @Autowired
  public S3Uploader(AmazonS3 amazonS3) {
    this.amazonS3 = amazonS3;
  }

  public String upload(MultipartFile file) throws IOException {
    String bucketName = "your-bucket-name"; // 설정한 버킷명 사용
    String key = "images/" + UUID.randomUUID() + "-" + file.getOriginalFilename();

    // MultipartFile을 File로 변환
    File convertedFile = convertMultipartFileToFile(file);

    try {
      // S3에 파일 업로드
      amazonS3.putObject(new PutObjectRequest(bucketName, key, convertedFile));
      // 파일 업로드 후 URL 반환
      return amazonS3.getUrl(bucketName, key).toString();
    } catch (Exception e) {
      throw new RuntimeException("S3 업로드 실패", e);
    } finally {
      // 업로드 완료됐으면 로컬 시스템에 저장된 파일 삭제
      convertedFile.delete();
    }
  }

  // MultipartFile을 File로 변환하는 메서드
  private File convertMultipartFileToFile(MultipartFile file) throws IOException {
    // 업로드된 파일의 원본 파일 이름을 가져옴
    File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
    // 파일을 로컬 시스템에 저장
    file.transferTo(convertedFile);
    return convertedFile;
  }
}
