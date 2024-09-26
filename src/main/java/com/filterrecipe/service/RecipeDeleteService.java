package com.filterrecipe.service;

import com.filterrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeDeleteService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
