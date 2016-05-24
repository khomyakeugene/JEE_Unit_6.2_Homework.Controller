package com.company.restaurant.model;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class Portion extends FloatLinkObject {
    private int portionId;
    private String description;

    public int getPortionId() {
        return portionId;
    }

    public void setPortionId(int portionId) {
        this.portionId = portionId;
    }

    public int getPortionTypeId() {
        return getFirstId();
    }

    public void setPortionTypeId(int portionTypeId) {
        setFirstId(portionTypeId);
    }

    public int getMeasuringTypeId() {
        return getSecondId();
    }

    public void setMeasuringTypeId(int measuringTypeId) {
        setSecondId(measuringTypeId);
    }

    public Float getAmount() {
        return getFloatLinkData();
    }

    public void setAmount(Float amount) {
        setFloatLinkData(amount);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
