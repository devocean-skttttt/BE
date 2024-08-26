package com.filterrecipe.recipe.repository;

import com.filterrecipe.auth.dto.User;
import com.filterrecipe.recipe.dto.Bookmark;
import com.filterrecipe.recipe.dto.Recipe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByUserAndRecipe(User user, Recipe recipe);
}
