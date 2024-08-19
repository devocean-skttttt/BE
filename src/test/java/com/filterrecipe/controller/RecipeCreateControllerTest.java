package com.filterrecipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filterrecipe.dto.RecipeCreateDTO;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.service.RecipeCreateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(RecipeCreateController.class)
public class RecipeCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeCreateService service;

    @Autowired
    private ObjectMapper objectMapper;

    private RecipeCreateDTO recipeCreateDTO;

    @BeforeEach
    public void setup() {
        recipeCreateDTO = new RecipeCreateDTO();
        recipeCreateDTO.setTitle("Test Title");
        recipeCreateDTO.setDescription("Test Description");
        recipeCreateDTO.setHashtags("#test");
        recipeCreateDTO.setOriginalPhoto("originalPhotoUrl");
        recipeCreateDTO.setAdjustedPhoto("adjustedPhotoUrl");
        recipeCreateDTO.setExposure(1.0);
        recipeCreateDTO.setBrightness(1.0);
        // Set other fields as necessary
    }

    @Test
    public void testCreateRecipe() throws Exception {
        RecipeCreate recipeCreate = new RecipeCreate();
        recipeCreate.setId(1L); // Set a mock ID
        recipeCreate.setTitle(recipeCreateDTO.getTitle());
        recipeCreate.setDescription(recipeCreateDTO.getDescription());
        recipeCreate.setHashtags(recipeCreateDTO.getHashtags());
        recipeCreate.setOriginalPhoto(recipeCreateDTO.getOriginalPhoto());
        recipeCreate.setAdjustedPhoto(recipeCreateDTO.getAdjustedPhoto());
        recipeCreate.setExposure(recipeCreateDTO.getExposure());
        recipeCreate.setBrightness(recipeCreateDTO.getBrightness());
        // Set other fields as necessary

        Mockito.when(service.saveRecipeCreate(Mockito.any(RecipeCreateDTO.class))).thenReturn(recipeCreate);

        mockMvc.perform(post("/api/recipes")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(recipeCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.id").value(1))
                .andDo(MockMvcResultHandlers.print());
    }
}
