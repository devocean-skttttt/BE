package com.filterrecipe.controller;

import com.filterrecipe.dto.RecipeCreateDTO;
import com.filterrecipe.model.RecipeCreate;
import com.filterrecipe.service.RecipeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeCreateController {

    @Autowired
    private RecipeCreateService service;

    @PostMapping
    public ResponseEntity<RecipeCreate> createRecipe(@RequestBody RecipeCreateDTO dto) {
        RecipeCreate savedRecipe = service.saveRecipeCreate(dto);
        return ResponseEntity.ok(savedRecipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeCreate> getRecipeById(@PathVariable Long id) {
        Optional<RecipeCreate> recipe = service.getRecipeById(id);
        return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
