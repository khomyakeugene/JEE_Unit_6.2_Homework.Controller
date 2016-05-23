package com.company.restaurant.model;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class Warehouse {
    private int ingredientId;
    private int portionId;
    private float amount;
    private String ingredientName;
    private int portionTypeId;
    private int measuringTypeId;



    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getPortionId() {
        return portionId;
    }

    public void setPortionId(int portionId) {
        this.portionId = portionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
