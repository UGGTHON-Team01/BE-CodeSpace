package com.uggthon.team01.dto;

import java.util.List;

import lombok.Data;

@Data
public class GenerateRequestDto {
  private List<String> scenario1;
  private List<String> scenario2;
  private String scenario3; // img아이디
  private List<String> scenario4;
}
