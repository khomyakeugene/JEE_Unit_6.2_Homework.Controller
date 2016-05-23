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
    private float portionAmount;
    private String portionDescription;
    private String portionTypeName;
    private String MeasuringTypeCode;
    private String measuringTypeName;

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

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getPortionTypeId() {
        return portionTypeId;
    }

    public void setPortionTypeId(int portionTypeId) {
        this.portionTypeId = portionTypeId;
    }

    public int getMeasuringTypeId() {
        return measuringTypeId;
    }

    public void setMeasuringTypeId(int measuringTypeId) {
        this.measuringTypeId = measuringTypeId;
    }

    public float getPortionAmount() {
        return portionAmount;
    }

    public void setPortionAmount(float portionAmount) {
        this.portionAmount = portionAmount;
    }

    public String getPortionDescription() {
        return portionDescription;
    }

    public void setPortionDescription(String portionDescription) {
        this.portionDescription = portionDescription;
    }

    public String getPortionTypeName() {
        return portionTypeName;
    }

    public void setPortionTypeName(String portionTypeName) {
        this.portionTypeName = portionTypeName;
    }

    public String getMeasuringTypeCode() {
        return MeasuringTypeCode;
    }

    public void setMeasuringTypeCode(String measuringTypeCode) {
        MeasuringTypeCode = measuringTypeCode;
    }

    public String getMeasuringTypeName() {
        return measuringTypeName;
    }

    public void setMeasuringTypeName(String measuringTypeName) {
        this.measuringTypeName = measuringTypeName;
    }
}
