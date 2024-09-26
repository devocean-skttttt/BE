package com.filterrecipe.service;

import com.filterrecipe.dto.RecipeCreateRequestDto;
import com.filterrecipe.dto.RecipeCreateResponseDto;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeUpdateService {

    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeCreateResponseDto updateRecipe(Long id, RecipeCreateRequestDto requestDto) {
        // ID로 레시피 찾기
        RecipeCreate recipe = recipeRepository.findById(id).orElse(null);

        // 레시피가 존재하는 경우 값 수정
        if (recipe != null) {
            recipe.setTitle(requestDto.getTitle());
            recipe.setDescription(requestDto.getDescription());
            recipe.setHashtags(requestDto.getHashtags());
            recipe.setBeforeImageUrl(requestDto.getBeforeImageUrl());
            recipe.setAfterImageUrl(requestDto.getAfterImageUrl());

            recipe.setExposure(requestDto.getExposure());
            recipe.setBrightness(requestDto.getBrightness());
            recipe.setContrast(requestDto.getContrast());
            recipe.setSaturation(requestDto.getSaturation());
            recipe.setWarmth(requestDto.getWarmth());
            recipe.setTint(requestDto.getTint());
            recipe.setSharpness(requestDto.getSharpness());
            recipe.setClarity(requestDto.getClarity());
            recipe.setNoiseReduction(requestDto.getNoiseReduction());
            recipe.setVignette(requestDto.getVignette());
            recipe.setHighlights(requestDto.getHighlights());
            recipe.setShadows(requestDto.getShadows());
            recipe.setBlackPoint(requestDto.getBlackPoint());
            recipe.setVibrance(requestDto.getVibrance());

            // 수정된 레시피 저장
            recipeRepository.save(recipe);
        }

        // 수정된 정보를 응답 DTO로 반환 (레시피가 없을 경우 null 반환)
        return recipe != null ? new RecipeCreateResponseDto(recipe) : null;
    }
}
