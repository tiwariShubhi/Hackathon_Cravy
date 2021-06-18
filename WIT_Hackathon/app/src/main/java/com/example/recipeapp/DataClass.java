package com.example.recipeapp;

import java.io.Serializable;

public class DataClass implements Serializable {
    private int recipeImage;
    private String recipeName;
    private String recipeCourse;
    private String recipeDuration;
    private int num;

    DataClass(int recipeImage, String recipeName, String recipeCourse, String recipeDuration, int num)
    {
        this.recipeImage = recipeImage;
        this.recipeName = recipeName;
        this.recipeCourse = recipeCourse;
        this.recipeDuration = recipeDuration;
        this.num = num;
    }
    public int getRecipeImage() {
        return recipeImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeCourse() {
        return recipeCourse;
    }

    public String getRecipeDuration() {
        return recipeDuration;
    }

    public int getNum() {
        return num;
    }



}
