package com.uggthon.team01.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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