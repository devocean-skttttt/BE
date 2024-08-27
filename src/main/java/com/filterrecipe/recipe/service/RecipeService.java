package com.filterrecipe.recipe.service;

import com.filterrecipe.auth.dto.User;
import com.filterrecipe.auth.repository.UserRepository;
import com.filterrecipe.common.exception.CustomException;
import com.filterrecipe.common.exception.ErrorCode;
import com.filterrecipe.recipe.dto.Bookmark;
import com.filterrecipe.recipe.dto.Recipe;
import com.filterrecipe.recipe.dto.RecipeDto;
import com.filterrecipe.recipe.dto.TagDto;
import com.filterrecipe.recipe.repository.BookmarkRepository;
import com.filterrecipe.recipe.repository.RecipeRepository;
import com.filterrecipe.recipe.repository.TagRepository;
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
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    // 레시피 단일 정보 조회
    public RecipeDto getRecipeInfo(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECIPE_NOT_FOUND));

        RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

        Set<TagDto> tagDtos = recipe.getTags().stream().map(tag -> {
            TagDto tagDto = new TagDto();
            tagDto.setTagId(tag.getTagId());
            tagDto.setTagName(tag.getTagName());
            return tagDto;
        }).collect(Collectors.toSet());

        return recipeDto;
    }

    // 태그 별 레시피 목록 조회
    public Set<RecipeDto> getRecipesByTag(Long tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new CustomException(ErrorCode.TAG_NOT_FOUND);
        }
        Set<Recipe> recipes = recipeRepository.findByTagsTagId(tagId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECIPE_NOT_FOUND));

        return recipes.stream().map(recipe -> {
            RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

            Set<TagDto> tagDtos = recipe.getTags().stream().map(tag -> {
                return modelMapper.map(tag, TagDto.class);
            }).collect(Collectors.toSet());

            recipeDto.setTags(tagDtos);

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
