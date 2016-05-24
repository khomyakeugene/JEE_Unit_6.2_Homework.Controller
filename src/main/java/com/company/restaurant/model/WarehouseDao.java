package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface WarehouseDao {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, Portion portion, float amount);

    Ingredient findIngredientByName(String name);

    List<Ingredient> findAllWarehouseIngredients();

    List<Ingredient> findAllElapsingWarehouseIngredients(float limit);
}
