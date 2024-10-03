package com.filterrecipe.recipe.service;

import com.filterrecipe.auth.dto.User;
import com.filterrecipe.auth.repository.UserRepository;
import com.filterrecipe.common.exception.CustomException;
import com.filterrecipe.common.exception.ErrorCode;
import com.filterrecipe.recipe.dto.Bookmark;
import com.filterrecipe.recipe.dto.Category;
import com.filterrecipe.recipe.dto.Recipe;
import com.filterrecipe.recipe.dto.RecipeDto;
import com.filterrecipe.recipe.dto.RecipeRequestDto;
import com.filterrecipe.recipe.dto.CategoryDto;
import com.filterrecipe.recipe.dto.RecipeResponseDto;
import com.filterrecipe.recipe.repository.BookmarkRepository;
import com.filterrecipe.recipe.repository.RecipeRepository;
import com.filterrecipe.recipe.repository.CategoryRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    // 레시피 등록
    public RecipeDto uploadRecipe(RecipeRequestDto dto) {
        Recipe recipe = modelMapper.map(dto, Recipe.class);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        recipe.setCategory(category);
        recipe.setTags(dto.getTags());

        Recipe savedRecipe = recipeRepository.save(recipe);

        RecipeDto response = modelMapper.map(savedRecipe, RecipeDto.class);
        response.setCategoryName(savedRecipe.getCategory().getCategoryName());

        return response;
    }

    // 레시피 단일 정보 조회
    public RecipeDto getRecipeInfo(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECIPE_NOT_FOUND));

        RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);
        recipeDto.setCategoryName(recipe.getCategory().getCategoryName());
        recipeDto.setTags(recipe.getTags());

        return recipeDto;
    }

    // 카테고리 별 레시피 목록 조회
    public Set<RecipeDto> getRecipesByCategory(Long categoryId) {
        Set<Recipe> recipes = recipeRepository.findByCategoryCategoryId(categoryId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECIPE_NOT_FOUND));

        return recipes.stream().map(recipe -> {
            RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);
            recipeDto.setCategoryName(recipe.getCategory().getCategoryName());
            recipeDto.setTags(recipe.getTags());
            return recipeDto;
        }).collect(Collectors.toSet());
    }

    // 북마크 저장
    public RecipeDto saveBookmark(Long userId, Long recipeId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECIPE_NOT_FOUND));

        // 이미 북마크가 되어 있는지 확인
        if (bookmarkRepository.findByUserAndRecipe(user, recipe).isPresent()) {
            throw new CustomException(ErrorCode.ALREADY_BOOKMARKED);
        }

        Bookmark bookmark = new Bookmark();
        bookmark.setRecipe(recipe);
        user.addBookmark(bookmark); // 유저에 북마크 추가

        bookmarkRepository.save(bookmark);

        return modelMapper.map(recipe, RecipeDto.class);
    }
}
