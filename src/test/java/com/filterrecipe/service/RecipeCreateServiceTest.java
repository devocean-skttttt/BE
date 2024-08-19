package com.filterrecipe.service;

import com.filterrecipe.dto.RecipeCreateDTO;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.repository.RecipeCreateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RecipeCreateServiceTest {

    @Mock
    private RecipeCreateRepository repository;

    @InjectMocks
    private RecipeCreateService service;

    private RecipeCreateDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dto = new RecipeCreateDTO();
        dto.setTitle("Test Recipe");
        dto.setDescription("Test Description");
        dto.setHashtags("#test");
        dto.setOriginalPhoto("original.jpg");
        dto.setAdjustedPhoto("adjusted.jpg");
        dto.setExposure(1.0);
        dto.setBrightness(1.0);
        dto.setHighlight(1.0);
        dto.setShadow(1.0);
        dto.setContrast(1.0);
        dto.setBlackPoint(1.0);
        dto.setSaturation(1.0);
        dto.setColorSharpness(1.0);
        dto.setWarmth(1.0);
        dto.setHue(1.0);
        dto.setSharpness(1.0);
        dto.setClarity(1.0);
        dto.setNoiseReduction(1.0);
        dto.setVignette(1.0);
    }

    @Test
    void testSaveRecipeCreate() {
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

        // Ensure the mock returns the recipeCreate object
        when(repository.save(any(RecipeCreate.class))).thenReturn(recipeCreate);

        // Call the service method
        RecipeCreate savedRecipe = service.saveRecipeCreate(dto);

        // Assert that the savedRecipe is not null and has the expected values
        assertEquals(dto.getTitle(), savedRecipe.getTitle());
        assertEquals(dto.getDescription(), savedRecipe.getDescription());
        assertEquals(dto.getHashtags(), savedRecipe.getHashtags());
        assertEquals(dto.getOriginalPhoto(), savedRecipe.getOriginalPhoto());
        assertEquals(dto.getAdjustedPhoto(), savedRecipe.getAdjustedPhoto());
        // Continue to check other fields if necessary
    }
}
