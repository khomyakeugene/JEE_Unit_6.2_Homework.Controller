package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface WarehouseDao {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, float amount);

    Warehouse findIngredientByName(String name);

    List<Warehouse> findAllWarehouseIngredients();

    List<Warehouse> findAllElapsingWarehouseIngredients(float limit);
}
