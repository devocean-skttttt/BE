package com.filterrecipe.recipe.controller;

import com.filterrecipe.common.util.ApiResponse;
import com.filterrecipe.recipe.dto.RecipeDto;
import com.filterrecipe.recipe.dto.RecipeRequestDto;
import com.filterrecipe.recipe.dto.RecipeResponseDto;
import com.filterrecipe.recipe.service.RecipeService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    // 레시피 등록
    @PostMapping("/")
    public ResponseEntity<ApiResponse<RecipeDto>> uploadRecipe(@RequestBody RecipeRequestDto dto) {
        RecipeDto response = recipeService.uploadRecipe(dto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 레시피 단일 정보 조회
    @GetMapping("/{recipeId}")
    public ResponseEntity<ApiResponse<RecipeDto>> getRecipeInfo(@PathVariable Long recipeId) {
        RecipeDto response = recipeService.getRecipeInfo(recipeId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 카테고리 별 레시피 목록 조회
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<Set<RecipeDto>>> getRecipesByCategory(@PathVariable Long categoryId) {
        Set<RecipeDto> response = recipeService.getRecipesByCategory(categoryId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 북마크 저장
    @PostMapping("/{recipeId}/bookmark")
    public ResponseEntity<ApiResponse<RecipeDto>> saveBookmark(@RequestParam Long userId, @PathVariable Long recipeId) {
        RecipeDto response = recipeService.saveBookmark(userId, recipeId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
