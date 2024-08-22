package com.filterrecipe.recipe.dto;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @ManyToMany
    @JoinTable(
            name = "recipe_tag",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Column
    private Long exposure;

    @Column
    private Long brilliance;

    @Column
    private Long highlights;

    @Column
    private Long shadows;

    @Column
    private Long contrast;

    @Column
    private Long brightness;

    @Column
    private Long blackPoint;

    @Column
    private Long saturation;

    @Column
    private Long vibrance;

    @Column
    private Long warmth;

    @Column
    private Long tint;

    @Column
    private Long sharpness;

    @Column
    private Long definition;

    @Column
    private Long noiseReduction;

    @Column
    private Long vignette;
}
