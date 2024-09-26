package com.filterrecipe.repository;

import com.filterrecipe.model.RecipeCreate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeCreate, Long> {
    // CRUD 메서드가 자동으로 제공됩니다.
}
