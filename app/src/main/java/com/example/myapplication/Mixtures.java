package com.example.myapplication;

public class Mixtures {
    double protein, fats, carbohydrates, calories;

    public Mixtures(double protein, double fats, double carbohydrates, double calories) {
        this.protein = protein;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getCalories() {
        return calories;
    }
}
