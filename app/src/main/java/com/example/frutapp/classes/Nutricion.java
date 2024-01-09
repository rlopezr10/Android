package com.example.frutapp.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutricion {

    @SerializedName("carbohydrates")
    @Expose
    private Float carbohydrates;
    @SerializedName("protein")
    @Expose
    private Float protein;
    @SerializedName("fat")
    @Expose
    private Double fat;
    @SerializedName("calories")
    @Expose
    private Float calories;
    @SerializedName("sugar")
    @Expose
    private Double sugar;

    public Float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

}
