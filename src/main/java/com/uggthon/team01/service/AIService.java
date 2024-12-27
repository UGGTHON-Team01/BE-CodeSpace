package com.uggthon.team01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uggthon.team01.dto.GenerateRequestDto;
import com.uggthon.team01.dto.GenerateResponseDto;

@Service
public class AIService {

  public GenerateResponseDto generateImages(GenerateRequestDto requestDto) {
    RestTemplate restTemplate = new RestTemplate();
    String aiServerUrl = "http://ai-server-url.com/generate"; // AI 서버 URL
    return restTemplate.postForObject(aiServerUrl, requestDto, GenerateResponseDto.class);
  }
}
