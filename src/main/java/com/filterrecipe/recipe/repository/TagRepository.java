package com.filterrecipe.recipe.repository;

import com.filterrecipe.recipe.dto.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}

