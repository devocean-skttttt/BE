package com.filterrecipe.recipe.repository;

import com.filterrecipe.recipe.dto.Recipe;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Set<Recipe>> findByCategoryCategoryId(Long categoryId);
}
