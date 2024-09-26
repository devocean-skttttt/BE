package com.filterrecipe.dto;

import com.filterrecipe.model.RecipeCreate;

public class RecipeCreateResponseDto {

    private Long id;
    private String title;
    private String description;
    private String hashtags;
    private String beforeImageUrl;
    private String afterImageUrl;

    private int exposure;
    private int brightness;
    private int contrast;
    private int saturation;
    private int warmth;
    private int tint;
    private int sharpness;
    private int clarity;
    private int noiseReduction;
    private int vignette;
    private int highlights;
    private int shadows;
    private int blackPoint;
    private int vibrance;

    // 기본 생성자
    public RecipeCreateResponseDto() {}

    // RecipeCreate 객체를 인자로 받는 생성자
    public RecipeCreateResponseDto(RecipeCreate recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.hashtags = recipe.getHashtags();
        this.beforeImageUrl = recipe.getBeforeImageUrl();
        this.afterImageUrl = recipe.getAfterImageUrl();
        this.exposure = recipe.getExposure();
        this.brightness = recipe.getBrightness();
        this.contrast = recipe.getContrast();
        this.saturation = recipe.getSaturation();
        this.warmth = recipe.getWarmth();
        this.tint = recipe.getTint();
        this.sharpness = recipe.getSharpness();
        this.clarity = recipe.getClarity();
        this.noiseReduction = recipe.getNoiseReduction();
        this.vignette = recipe.getVignette();
        this.highlights = recipe.getHighlights();
        this.shadows = recipe.getShadows();
        this.blackPoint = recipe.getBlackPoint();
        this.vibrance = recipe.getVibrance();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getHashtags() { return hashtags; }
    public void setHashtags(String hashtags) { this.hashtags = hashtags; }

    public String getBeforeImageUrl() { return beforeImageUrl; }
    public void setBeforeImageUrl(String beforeImageUrl) { this.beforeImageUrl = beforeImageUrl; }

    public String getAfterImageUrl() { return afterImageUrl; }
    public void setAfterImageUrl(String afterImageUrl) { this.afterImageUrl = afterImageUrl; }

    public int getExposure() { return exposure; }
    public void setExposure(int exposure) { this.exposure = exposure; }

    public int getBrightness() { return brightness; }
    public void setBrightness(int brightness) { this.brightness = brightness; }

    public int getContrast() { return contrast; }
    public void setContrast(int contrast) { this.contrast = contrast; }

    public int getSaturation() { return saturation; }
    public void setSaturation(int saturation) { this.saturation = saturation; }

    public int getWarmth() { return warmth; }
    public void setWarmth(int warmth) { this.warmth = warmth; }

    public int getTint() { return tint; }
    public void setTint(int tint) { this.tint = tint; }

    public int getSharpness() { return sharpness; }
    public void setSharpness(int sharpness) { this.sharpness = sharpness; }

    public int getClarity() { return clarity; }
    public void setClarity(int clarity) { this.clarity = clarity; }

    public int getNoiseReduction() { return noiseReduction; }
    public void setNoiseReduction(int noiseReduction) { this.noiseReduction = noiseReduction; }

    public int getVignette() { return vignette; }
    public void setVignette(int vignette) { this.vignette = vignette; }

    public int getHighlights() { return highlights; }
    public void setHighlights(int highlights) { this.highlights = highlights; }

    public int getShadows() { return shadows; }
    public void setShadows(int shadows) { this.shadows = shadows; }

    public int getBlackPoint() { return blackPoint; }
    public void setBlackPoint(int blackPoint) { this.blackPoint = blackPoint; }

    public int getVibrance() { return vibrance; }
    public void setVibrance(int vibrance) { this.vibrance = vibrance; }
}
