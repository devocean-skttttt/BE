package com.filterrecipe.controller;

import com.filterrecipe.dto.RecipeCreateRequestDto;
import com.filterrecipe.dto.RecipeCreateResponseDto;
import com.filterrecipe.service.RecipeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
public class RecipeCreateController {

    @Autowired
    private RecipeCreateService recipeCreateService;

    @PostMapping
    public ResponseEntity<RecipeCreateResponseDto> createRecipe(@RequestBody RecipeCreateRequestDto requestDto) {
        RecipeCreateResponseDto responseDto = recipeCreateService.createRecipe(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeCreateResponseDto> updateRecipe(
            @PathVariable Long id,
            @RequestBody RecipeCreateRequestDto requestDto) {
        RecipeCreateResponseDto responseDto = recipeCreateService.updateRecipe(id, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
