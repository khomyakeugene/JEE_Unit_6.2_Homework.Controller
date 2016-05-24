package com.company.restaurant.model;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class Ingredient extends SimpleDic {
    public int getIngredient() {
        return getId();
    }

    public void setIngredient(int ingredientId) {
        setId(ingredientId);
    }
}
