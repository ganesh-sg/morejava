package com.ganesh.learn.more.java;

public class NutritionFactsAutoBuilder {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrades;

    public NutritionFactsAutoBuilder setServingSize(int servingSize) {
        this.servingSize = servingSize;
        return this;
    }

    public NutritionFactsAutoBuilder setServings(int servings) {
        this.servings = servings;
        return this;
    }

    public NutritionFactsAutoBuilder setCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public NutritionFactsAutoBuilder setFat(int fat) {
        this.fat = fat;
        return this;
    }

    public NutritionFactsAutoBuilder setSodium(int sodium) {
        this.sodium = sodium;
        return this;
    }

    public NutritionFactsAutoBuilder setCarbohydrades(int carbohydrades) {
        this.carbohydrades = carbohydrades;
        return this;
    }

    public NutritionFactsAuto createNutritionFactsAuto() {
        return new NutritionFactsAuto(servingSize, servings, calories, fat, sodium, carbohydrades);
    }
}