package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class WarehouseAdapter {
    private WarehouseDao warehouseDao;
    private IngredientDao ingredientDao;
    private PortionDao portionDao;

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public PortionDao getPortionDao() {
        return portionDao;
    }

    public void setPortionDao(PortionDao portionDao) {
        this.portionDao = portionDao;
    }

    public void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount) {
        warehouseDao.addIngredientToWarehouse(ingredient, portion, amount);
    }

    public void takeIngredientFromWarehouse(Ingredient ingredient, float amount) {
        warehouseDao.takeIngredientFromWarehouse(ingredient, amount);
    }

    public List<Warehouse> findIngredientInWarehouseByName(String name) {
        return warehouseDao.findIngredientInWarehouseByName(name);
    }

    public List<Warehouse> findIngredientInWarehouseById(int ingredientId) {
        return warehouseDao.findIngredientInWarehouseById(ingredientId);
    }

    public List<Warehouse> findAllWarehouseIngredients() {
        return warehouseDao.findAllWarehouseIngredients();
    }

    public List<Warehouse> findAllElapsingWarehouseIngredients(float limit) {
        return warehouseDao.findAllElapsingWarehouseIngredients(limit);
    }
}
