package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class WarehouseAdapter {
    private WarehouseDao warehouseDao;

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount) {
        warehouseDao.addIngredientToWarehouse(ingredient, portion, amount);
    }

    public void takeIngredientFromWarehouse(Ingredient ingredient, float amount) {
        warehouseDao.takeIngredientFromWarehouse(ingredient, amount);
    }

    public Warehouse findIngredientByName(String name) {
        return warehouseDao.findIngredientByName(name);
    }

    public List<Warehouse> findAllWarehouseIngredients() {
        return warehouseDao.findAllWarehouseIngredients();
    }

    public List<Warehouse> findAllElapsingWarehouseIngredients(float limit) {
        return warehouseDao.findAllElapsingWarehouseIngredients(limit);
    }
}
