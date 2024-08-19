package com.filterrecipe.service;

import com.filterrecipe.dto.RecipeCreateDTO;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.repository.RecipeCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeCreateService {

    @Autowired
    private RecipeCreateRepository repository;

    public RecipeCreate saveRecipeCreate(RecipeCreateDTO dto) {
        RecipeCreate recipeCreate = new RecipeCreate();
        recipeCreate.setTitle(dto.getTitle());
        recipeCreate.setDescription(dto.getDescription());
        recipeCreate.setHashtags(dto.getHashtags());
        recipeCreate.setOriginalPhoto(dto.getOriginalPhoto());
        recipeCreate.setAdjustedPhoto(dto.getAdjustedPhoto());
        recipeCreate.setExposure(dto.getExposure());
        recipeCreate.setBrightness(dto.getBrightness());
        recipeCreate.setHighlight(dto.getHighlight());
        recipeCreate.setShadow(dto.getShadow());
        recipeCreate.setContrast(dto.getContrast());
        recipeCreate.setBlackPoint(dto.getBlackPoint());
        recipeCreate.setSaturation(dto.getSaturation());
        recipeCreate.setColorSharpness(dto.getColorSharpness());
        recipeCreate.setWarmth(dto.getWarmth());
        recipeCreate.setHue(dto.getHue());
        recipeCreate.setSharpness(dto.getSharpness());
        recipeCreate.setClarity(dto.getClarity());
        recipeCreate.setNoiseReduction(dto.getNoiseReduction());
        recipeCreate.setVignette(dto.getVignette());

        return repository.save(recipeCreate);
    }

    public Optional<RecipeCreate> getRecipeById(Long id) {
        return repository.findById(id);
    }
}
