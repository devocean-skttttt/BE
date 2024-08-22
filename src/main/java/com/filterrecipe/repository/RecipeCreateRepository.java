package com.filterrecipe.repository;

import com.filterrecipe.model.RecipeCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCreateRepository extends JpaRepository<RecipeCreate, Long> {
}
