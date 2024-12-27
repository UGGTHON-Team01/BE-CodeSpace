package com.uggthon.team01.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenerateResponseDto {
  private List<OutfitOption> outfitOptions;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class OutfitOption {
    private String topImageUrl;
    private String bottomImageUrl;
    private String description;
  }
}
