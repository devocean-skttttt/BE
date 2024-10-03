package com.filterrecipe.recipe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseDto {
    private Long recipeId;
    private Category category;
    private String tags;
    private Long exposure;
    private Long brilliance;
    private Long highlights;
    private Long shadows;
    private Long contrast;
    private Long brightness;
    private Long blackPoint;
    private Long saturation;
    private Long vibrance;
    private Long warmth;
    private Long tint;
    private Long sharpness;
    private Long definition;
    private Long noiseReduction;
    private Long vignette;
}
