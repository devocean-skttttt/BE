package com.filterrecipe.recipe.service;

import com.filterrecipe.common.exception.CustomException;
import com.filterrecipe.common.exception.ErrorCode;
import com.filterrecipe.recipe.dto.Recipe;
import com.filterrecipe.recipe.dto.RecipeDto;
import com.filterrecipe.recipe.dto.TagDto;
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
    private final RecipeRepository recipeRepository;
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

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
}
