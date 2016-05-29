package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface IngredientDao {
    Ingredient addIngredient(String name);

    String delIngredient(String name);

    List<Ingredient> findAllIngredients();

    Ingredient findIngredientById(int ingredientId);
}
