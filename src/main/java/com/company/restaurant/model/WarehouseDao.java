package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface WarehouseDao {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, Portion portion, float amount);

    List<Warehouse> findIngredientInWarehouseByName(String name);

    List<Warehouse> findIngredientInWarehouseById(int ingredientId);

    List<Warehouse> findAllWarehouseIngredients();

    List<Warehouse> findAllElapsingWarehouseIngredients(float limit);
}
