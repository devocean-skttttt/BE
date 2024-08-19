package com.filterrecipe.repository;

import com.filterrecipe.model.RecipeCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCreateRepository extends JpaRepository<RecipeCreate, Long> {
    // 기본적인 CRUD 메서드는 JpaRepository에서 자동으로 제공됨
}
