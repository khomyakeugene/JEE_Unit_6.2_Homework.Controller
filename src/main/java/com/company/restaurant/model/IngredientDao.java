package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface IngredientDao {
    Ingredient addIngredient(String name);

    void delIngredient(String name);

    List<Ingredient> findAllIngredients();
}
