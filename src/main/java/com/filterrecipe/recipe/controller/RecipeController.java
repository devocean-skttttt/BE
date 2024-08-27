package com.filterrecipe.recipe.controller;

import com.filterrecipe.common.util.ApiResponse;
import com.filterrecipe.recipe.dto.RecipeDto;
import com.filterrecipe.recipe.service.RecipeService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    // 레시피 단일 정보 조회
    @GetMapping("/{recipeId}")
    public ResponseEntity<ApiResponse<RecipeDto>> getRecipeInfo(@PathVariable Long recipeId) {
        RecipeDto response = recipeService.getRecipeInfo(recipeId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 태그 별 레시피 목록 조회
    @GetMapping("/tag/{tagId}")
    public ResponseEntity<ApiResponse<Set<RecipeDto>>> getRecipesByTag(@PathVariable Long tagId) {
        Set<RecipeDto> response = recipeService.getRecipesByTag(tagId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 북마크 저장
    @PostMapping("/{recipeId}/bookmark")
    public ResponseEntity<ApiResponse<RecipeDto>> saveBookmark(@RequestParam Long userId, @PathVariable Long recipeId) {
        RecipeDto response = recipeService.saveBookmark(userId, recipeId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
