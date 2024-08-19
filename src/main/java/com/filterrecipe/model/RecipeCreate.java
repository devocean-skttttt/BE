package com.filterrecipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecipeCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String hashtags;
    private String originalPhoto;
    private String adjustedPhoto;

    private Double exposure;
    private Double brightness;
    private Double highlight;
    private Double shadow;
    private Double contrast;
    private Double blackPoint;
    private Double saturation;
    private Double colorSharpness;
    private Double warmth;
    private Double hue;
    private Double sharpness;
    private Double clarity;
    private Double noiseReduction;
    private Double vignette;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getOriginalPhoto() {
        return originalPhoto;
    }

    public void setOriginalPhoto(String originalPhoto) {
        this.originalPhoto = originalPhoto;
    }

    public String getAdjustedPhoto() {
        return adjustedPhoto;
    }

    public void setAdjustedPhoto(String adjustedPhoto) {
        this.adjustedPhoto = adjustedPhoto;
    }

    public Double getExposure() {
        return exposure;
    }

    public void setExposure(Double exposure) {
        this.exposure = exposure;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    public Double getHighlight() {
        return highlight;
    }

    public void setHighlight(Double highlight) {
        this.highlight = highlight;
    }

    public Double getShadow() {
        return shadow;
    }

    public void setShadow(Double shadow) {
        this.shadow = shadow;
    }

    public Double getContrast() {
        return contrast;
    }

    public void setContrast(Double contrast) {
        this.contrast = contrast;
    }

    public Double getBlackPoint() {
        return blackPoint;
    }

    public void setBlackPoint(Double blackPoint) {
        this.blackPoint = blackPoint;
    }

    public Double getSaturation() {
        return saturation;
    }

    public void setSaturation(Double saturation) {
        this.saturation = saturation;
    }

    public Double getColorSharpness() {
        return colorSharpness;
    }

    public void setColorSharpness(Double colorSharpness) {
        this.colorSharpness = colorSharpness;
    }

    public Double getWarmth() {
        return warmth;
    }

    public void setWarmth(Double warmth) {
        this.warmth = warmth;
    }

    public Double getHue() {
        return hue;
    }

    public void setHue(Double hue) {
        this.hue = hue;
    }

    public Double getSharpness() {
        return sharpness;
    }

    public void setSharpness(Double sharpness) {
        this.sharpness = sharpness;
    }

    public Double getClarity() {
        return clarity;
    }

    public void setClarity(Double clarity) {
        this.clarity = clarity;
    }

    public Double getNoiseReduction() {
        return noiseReduction;
    }

    public void setNoiseReduction(Double noiseReduction) {
        this.noiseReduction = noiseReduction;
    }

    public Double getVignette() {
        return vignette;
    }

    public void setVignette(Double vignette) {
        this.vignette = vignette;
    }
}
