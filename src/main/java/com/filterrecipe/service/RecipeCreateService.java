package com.filterrecipe.service;

import com.filterrecipe.dto.RecipeCreateRequestDto;
import com.filterrecipe.dto.RecipeCreateResponseDto;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.repository.RecipeCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeCreateService {

    @Autowired
    private RecipeCreateRepository recipeCreateRepository;

    public RecipeCreateResponseDto createRecipe(RecipeCreateRequestDto requestDto) {
        RecipeCreate recipe = new RecipeCreate();
        // requestDto에서 recipe로 값 복사
        mapDtoToEntity(requestDto, recipe);

        recipeCreateRepository.save(recipe);

        // ResponseDto로 변환하여 반환
        return mapEntityToDto(recipe);
    }

    public RecipeCreateResponseDto updateRecipe(Long id, RecipeCreateRequestDto requestDto) {
        RecipeCreate recipe = recipeCreateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));

        // requestDto에서 recipe로 값 복사
        mapDtoToEntity(requestDto, recipe);

        recipeCreateRepository.save(recipe);

        // ResponseDto로 변환하여 반환
        return mapEntityToDto(recipe);
    }

    private void mapDtoToEntity(RecipeCreateRequestDto dto, RecipeCreate entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setHashtags(dto.getHashtags());
        entity.setBeforeImageUrl(dto.getBeforeImageUrl());
        entity.setAfterImageUrl(dto.getAfterImageUrl());
        entity.setExposure(dto.getExposure());
        entity.setBrightness(dto.getBrightness());
        entity.setContrast(dto.getContrast());
        entity.setSaturation(dto.getSaturation());
        entity.setWarmth(dto.getWarmth());
        entity.setTint(dto.getTint());
        entity.setSharpness(dto.getSharpness());
        entity.setClarity(dto.getClarity());
        entity.setNoiseReduction(dto.getNoiseReduction());
        entity.setVignette(dto.getVignette());
        entity.setHighlights(dto.getHighlights());
        entity.setShadows(dto.getShadows());
        entity.setBlackPoint(dto.getBlackPoint());
        entity.setVibrance(dto.getVibrance());
    }

    private RecipeCreateResponseDto mapEntityToDto(RecipeCreate entity) {
        RecipeCreateResponseDto dto = new RecipeCreateResponseDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setHashtags(entity.getHashtags());
        dto.setBeforeImageUrl(entity.getBeforeImageUrl());
        dto.setAfterImageUrl(entity.getAfterImageUrl());
        dto.setExposure(entity.getExposure());
        dto.setBrightness(entity.getBrightness());
        dto.setContrast(entity.getContrast());
        dto.setSaturation(entity.getSaturation());
        dto.setWarmth(entity.getWarmth());
        dto.setTint(entity.getTint());
        dto.setSharpness(entity.getSharpness());
        dto.setClarity(entity.getClarity());
        dto.setNoiseReduction(entity.getNoiseReduction());
        dto.setVignette(entity.getVignette());
        dto.setHighlights(entity.getHighlights());
        dto.setShadows(entity.getShadows());
        dto.setBlackPoint(entity.getBlackPoint());
        dto.setVibrance(entity.getVibrance());
        return dto;
    }
}
